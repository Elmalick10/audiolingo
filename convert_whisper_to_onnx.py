import torch
import whisper

model = whisper.load_model("tiny")

dummy = torch.randn(1,80,3000)

torch.onnx.export(
    model.encoder,
    dummy,
    "C:/audiolingo/models/whisper/tiny.onnx",
    input_names=["mel"],
    output_names=["embedding"],
    opset_version=17
)

print("ONNX export finished")