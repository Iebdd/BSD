from pathlib import Path


_PROJECT_ROOT = Path(__file__).resolve().parent

#DATA_ROOT = _PROJECT_ROOT / "Datasets"
DATA_ROOT = _PROJECT_ROOT / "Datasets" / "realdata"
#MODEL_PATH = _PROJECT_ROOT / "rps_cnn_model_base.keras"
#MODEL_PATH = _PROJECT_ROOT / "rps_cnn_model_data_aug.keras"
MODEL_PATH = _PROJECT_ROOT / "rps_cnn_model_base_early_stop_data_aug.keras"
