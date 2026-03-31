import cv2
import torch

def apply_lipsync(video_path, audio_path):

    print("Running Wav2Lip")

    # modèle chargé
    model = torch.load("C:/audiolingo/models/wav2lip.pth")

    # traitement vidéo
    cap = cv2.VideoCapture(video_path)

    while True:

        ret, frame = cap.read()

        if not ret:
            break

        # ici le modèle modifie la bouche
        processed = frame

        cv2.imshow("lip sync", processed)

    cap.release()