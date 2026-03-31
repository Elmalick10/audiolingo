from flask import Blueprint, request, jsonify

voice_route = Blueprint("voice", __name__)

@voice_route.route("/voice", methods=["POST"])
def voice():
    text = request.json["text"]

    # ici XTTS ou modèle
    return jsonify({"audio": "generated"})