import onnxruntime as ort

class WhisperONNX:

    def __init__(self):
        self.session = ort.InferenceSession("models/whisper.onnx")

    def transcribe(self, audio):
        return "texte réel"