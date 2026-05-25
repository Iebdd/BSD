import argparse

import cv2
import numpy as np
import tensorflow as tf

from project_config import MODEL_PATH


CLASS_LABELS = ["paper", "rock", "scissors"]
IMG_SIZE = 150


def preprocess_frame(frame: np.ndarray, img_size: int) -> np.ndarray:
    """Resize and normalize one webcam frame to the model's expected input shape."""
    resized = cv2.resize(frame, (img_size, img_size))
    rgb = cv2.cvtColor(resized, cv2.COLOR_BGR2RGB)
    normalized = rgb.astype("float32") / 255.0
    return np.expand_dims(normalized, axis=0)


def predict_frame(model: tf.keras.Model, frame: np.ndarray) -> tuple[str, float]:
    """Run inference on one frame and return the predicted label with its confidence."""
    batch = preprocess_frame(frame, IMG_SIZE)
    prediction = model.predict(batch, verbose=0)[0]
    class_index = int(np.argmax(prediction))
    confidence = float(np.max(prediction))
    return CLASS_LABELS[class_index], confidence


def main() -> None:
    """Load the trained model, open the webcam, and classify frames on demand."""
    parser = argparse.ArgumentParser(description="Test the RPS CNN model with a webcam.")
    parser.add_argument("--camera", type=int, default=0, help="Webcam index to open.")
    args = parser.parse_args()

    if not MODEL_PATH.exists():
        raise FileNotFoundError(f"Model file not found: {MODEL_PATH}")

    model = tf.keras.models.load_model(MODEL_PATH)
    cap = cv2.VideoCapture(args.camera)

    if not cap.isOpened():
        raise RuntimeError(f"Could not open webcam at index {args.camera}")

    print("Press SPACE to classify the current frame.")
    print("Press Q to quit.")

    prediction_text = "No prediction yet"

    try:
        while True:
            ok, frame = cap.read()
            if not ok:
                raise RuntimeError("Failed to read a frame from the webcam.")

            frame = cv2.flip(frame, 1)
            display_frame = frame.copy()

            height, width = display_frame.shape[:2]
            box_size = min(height, width) // 2
            x1 = (width - box_size) // 2
            y1 = (height - box_size) // 2
            x2 = x1 + box_size
            y2 = y1 + box_size

            roi = frame[y1:y2, x1:x2]

            cv2.rectangle(display_frame, (x1, y1), (x2, y2), (0, 255, 0), 2)
            cv2.putText(
                display_frame,
                prediction_text,
                (20, 40),
                cv2.FONT_HERSHEY_SIMPLEX,
                1.0,
                (0, 255, 0),
                2,
                cv2.LINE_AA,
            )
            cv2.putText(
                display_frame,
                "SPACE: predict | Q: quit",
                (20, height - 20),
                cv2.FONT_HERSHEY_SIMPLEX,
                0.7,
                (255, 255, 255),
                2,
                cv2.LINE_AA,
            )

            cv2.imshow("Rock Paper Scissors Webcam Test", display_frame)
            key = cv2.waitKey(1) & 0xFF

            if key == ord(" "):
                predicted_class, confidence = predict_frame(model, roi)
                prediction_text = f"{predicted_class} ({confidence:.3f})"
            elif key == ord("q"):
                break
    finally:
        cap.release()
        cv2.destroyAllWindows()


if __name__ == "__main__":
    main()
