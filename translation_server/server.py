from transformers import pipeline
from flask import Flask, request

app = Flask(__name__)

translator = pipeline("translation", model="facebook/nllb-200-distilled-600M")

@app.route("/translate", methods=["POST"])
def translate():
    text = request.json["text"]
    result = translator(text, src_lang="fra_Latn", tgt_lang="eng_Latn")
    return {"text": result[0]["translation_text"]}

app.run(host="0.0.0.0", port=5000)