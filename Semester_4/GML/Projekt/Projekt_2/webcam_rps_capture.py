import argparse
import time
from ctypes import windll
from dataclasses import dataclass
from pathlib import Path

import cv2

from project_config import DATA_ROOT


TRAIN_ROOT = DATA_ROOT / "rps"
VALIDATION_ROOT = DATA_ROOT / "rps-test-set"
CLASS_LABELS = ["rock", "paper", "scissors"]
WINDOW_NAME = "RPS Data Capture"
SPACE_VK = 0x20
WINDOW_WIDTH = 960
WINDOW_HEIGHT = 720
BUTTON_BAR_HEIGHT = 90
STATUS_BAR_HEIGHT = 90


@dataclass
class Button:
    """Simple clickable rectangle used as a control in the OpenCV window."""

    label: str
    x1: int
    y1: int
    x2: int
    y2: int

    def contains(self, x: int, y: int) -> bool:
        """Return True when a mouse click falls inside this button."""
        return self.x1 <= x <= self.x2 and self.y1 <= y <= self.y2


def ensure_output_dirs() -> None:
    """Create the training and validation class folders if they do not exist yet."""
    for root in (TRAIN_ROOT, VALIDATION_ROOT):
        for label in CLASS_LABELS:
            (root / label).mkdir(parents=True, exist_ok=True)


def build_buttons() -> dict[str, Button]:
    """Define the static button layout shown at the top of the webcam window."""
    return {
        "rock": Button("Rock", 20, 20, 140, 60),
        "paper": Button("Paper", 160, 20, 280, 60),
        "scissors": Button("Scissors", 300, 20, 440, 60),
        "train": Button("Train", 480, 20, 600, 60),
        "validation": Button("Validation", 620, 20, 780, 60),
    }


def draw_button(frame, button: Button, active: bool, color_active, color_inactive) -> None:
    """Render one button and highlight it when it is the current selection."""
    color = color_active if active else color_inactive
    cv2.rectangle(frame, (button.x1, button.y1), (button.x2, button.y2), color, -1)
    cv2.rectangle(frame, (button.x1, button.y1), (button.x2, button.y2), (255, 255, 255), 2)
    cv2.putText(
        frame,
        button.label,
        (button.x1 + 10, button.y1 + 28),
        cv2.FONT_HERSHEY_SIMPLEX,
        0.7,
        (255, 255, 255),
        2,
        cv2.LINE_AA,
    )


def save_image(output_path: Path, image) -> None:
    """Save one image to disk using a Unicode-safe write path on Windows."""
    success, encoded = cv2.imencode(".png", image)
    if not success:
        raise RuntimeError("Failed to encode image for saving.")
    encoded.tofile(str(output_path))


def is_space_pressed() -> bool:
    """Return True while the space bar is currently held down."""
    return bool(windll.user32.GetAsyncKeyState(SPACE_VK) & 0x8000)


def draw_overlay(canvas, frame_area: tuple[int, int, int, int], buttons: dict[str, Button], selected_class: str, selected_split: str, saving: bool, saved_count: int) -> None:
    """Draw controls and status text around the camera image without scaling UI elements."""
    draw_button(canvas, buttons["rock"], selected_class == "rock", (60, 130, 220), (70, 70, 70))
    draw_button(canvas, buttons["paper"], selected_class == "paper", (60, 130, 220), (70, 70, 70))
    draw_button(canvas, buttons["scissors"], selected_class == "scissors", (60, 130, 220), (70, 70, 70))
    draw_button(canvas, buttons["train"], selected_split == "train", (0, 150, 0), (70, 70, 70))
    draw_button(canvas, buttons["validation"], selected_split == "validation", (0, 150, 0), (70, 70, 70))

    x1, y1, x2, y2 = frame_area
    cv2.rectangle(canvas, (x1, y1), (x2, y2), (0, 255, 0), 2)
    cv2.putText(
        canvas,
        f"Class: {selected_class} | Split: {selected_split} | Saved: {saved_count} | Saving: {'ON' if saving else 'OFF'}",
        (20, WINDOW_HEIGHT - 50),
        cv2.FONT_HERSHEY_SIMPLEX,
        0.75,
        (255, 255, 255),
        2,
        cv2.LINE_AA,
    )
    cv2.putText(
        canvas,
        "Click class/split buttons. Hold SPACE to save images continuously. Press Q to quit.",
        (20, WINDOW_HEIGHT - 20),
        cv2.FONT_HERSHEY_SIMPLEX,
        0.65,
        (255, 255, 255),
        2,
        cv2.LINE_AA,
    )


def build_canvas(frame):
    """Place the camera frame on a larger fixed-size canvas without scaling it."""
    canvas = cv2.copyMakeBorder(
        frame,
        BUTTON_BAR_HEIGHT,
        STATUS_BAR_HEIGHT,
        max((WINDOW_WIDTH - frame.shape[1]) // 2, 0),
        max((WINDOW_WIDTH - frame.shape[1]) // 2, 0),
        cv2.BORDER_CONSTANT,
        value=(30, 30, 30),
    )
    canvas_height, canvas_width = canvas.shape[:2]
    target_height = max(canvas_height, WINDOW_HEIGHT)
    target_width = max(canvas_width, WINDOW_WIDTH)
    if target_height != canvas_height or target_width != canvas_width:
        extra_bottom = target_height - canvas_height
        extra_right = target_width - canvas_width
        canvas = cv2.copyMakeBorder(
            canvas,
            0,
            extra_bottom,
            0,
            extra_right,
            cv2.BORDER_CONSTANT,
            value=(30, 30, 30),
        )

    frame_x1 = max((canvas.shape[1] - frame.shape[1]) // 2, 0)
    frame_y1 = BUTTON_BAR_HEIGHT
    frame_x2 = frame_x1 + frame.shape[1]
    frame_y2 = frame_y1 + frame.shape[0]
    canvas[frame_y1:frame_y2, frame_x1:frame_x2] = frame
    return canvas, (frame_x1, frame_y1, frame_x2, frame_y2)


def get_output_path(selected_class: str, selected_split: str) -> Path:
    """Build a unique image path in the selected dataset split and class folder."""
    root = TRAIN_ROOT if selected_split == "train" else VALIDATION_ROOT
    timestamp = time.strftime("%Y%m%d_%H%M%S")
    target_dir = root / selected_class
    existing = len(list(target_dir.glob("*.png")))
    return target_dir / f"{selected_class}_{timestamp}_{existing:04d}.png"


def main() -> None:
    """Open the webcam and save cropped hand-sign images into train or validation folders."""
    parser = argparse.ArgumentParser(description="Capture Rock-Paper-Scissors images from a webcam.")
    parser.add_argument("--camera", type=int, default=0, help="Webcam index to open.")
    parser.add_argument("--interval", type=float, default=0.5, help="Seconds between saved frames while recording.")
    args = parser.parse_args()

    ensure_output_dirs()
    buttons = build_buttons()

    state = {
        "selected_class": "rock",
        "selected_split": "train",
        "saved_count": 0,
    }

    def handle_click(event, x, y, flags, param) -> None:
        """Update the current selection when the user clicks one of the control buttons."""
        if event != cv2.EVENT_LBUTTONDOWN:
            return

        for key, button in buttons.items():
            if not button.contains(x, y):
                continue
            if key in CLASS_LABELS:
                state["selected_class"] = key
            elif key in ("train", "validation"):
                state["selected_split"] = key
            break

    cap = cv2.VideoCapture(args.camera)
    if not cap.isOpened():
        raise RuntimeError(f"Could not open webcam at index {args.camera}")

    cv2.namedWindow(WINDOW_NAME, cv2.WINDOW_NORMAL)
    cv2.resizeWindow(WINDOW_NAME, WINDOW_WIDTH, WINDOW_HEIGHT)
    cv2.setMouseCallback(WINDOW_NAME, handle_click)

    last_saved_at = 0.0

    try:
        while True:
            ok, frame = cap.read()
            if not ok:
                raise RuntimeError("Failed to read a frame from the webcam.")

            frame = cv2.flip(frame, 1)
            saving = is_space_pressed()
            canvas, frame_area = build_canvas(frame)
            frame_x1, frame_y1, _, _ = frame_area
            frame_height, frame_width = frame.shape[:2]

            box_size = min(frame_height, frame_width) // 2
            x1 = frame_x1 + (frame_width - box_size) // 2
            y1 = frame_y1 + (frame_height - box_size) // 2
            x2 = x1 + box_size
            y2 = y1 + box_size

            draw_overlay(
                canvas,
                frame_area,
                buttons,
                state["selected_class"],
                state["selected_split"],
                saving,
                state["saved_count"],
            )
            cv2.rectangle(canvas, (x1, y1), (x2, y2), (0, 255, 255), 2)
            roi = frame[y1 - frame_y1:y2 - frame_y1, x1 - frame_x1:x2 - frame_x1]

            if saving and roi.size > 0 and time.time() - last_saved_at >= args.interval:
                output_path = get_output_path(state["selected_class"], state["selected_split"])
                save_image(output_path, roi)
                state["saved_count"] += 1
                last_saved_at = time.time()

            cv2.imshow(WINDOW_NAME, canvas)
            key = cv2.waitKey(1) & 0xFF

            if key == ord("q"):
                break
    finally:
        cap.release()
        cv2.destroyAllWindows()


if __name__ == "__main__":
    main()
