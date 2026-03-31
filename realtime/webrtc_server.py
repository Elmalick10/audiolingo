from aiortc import RTCPeerConnection, VideoStreamTrack
import cv2

class VideoTrack(VideoStreamTrack):
    def __init__(self):
        super().__init__()
        self.cap = cv2.VideoCapture("C:\\audiolingo\\output\\live.mp4")

    async def recv(self):
        ret, frame = self.cap.read()
        if not ret:
            self.cap.set(cv2.CAP_PROP_POS_FRAMES, 0)
            ret, frame = self.cap.read()

        return frame