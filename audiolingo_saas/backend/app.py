from flask import Flask, request, jsonify
from flask_jwt_extended import (
    JWTManager, create_access_token, jwt_required
)
import bcrypt

app = Flask(__name__)
app.config["JWT_SECRET_KEY"] = "SECRET_KEY"

jwt = JWTManager(app)

users = {}

@app.route("/register", methods=["POST"])
def register():
    data = request.json

    password = bcrypt.hashpw(
        data["password"].encode(), bcrypt.gensalt()
    )

@app.before_request
def limit():
    # limiter requêtes (anti-bot)
    pass

    users[data["email"]] = password

    return jsonify({"msg": "User created"})


@app.route("/login", methods=["POST"])
def login():
    data = request.json

    if data["email"] in users:
        if bcrypt.checkpw(
            data["password"].encode(),
            users[data["email"]]
        ):
            token = create_access_token(identity=data["email"])
            return jsonify({"token": token})

    return jsonify({"msg": "Error"}), 401


@app.route("/protected")
@jwt_required()
def protected():
    return jsonify({"msg": "OK"})

@app.route("/stats")
@jwt_required()
def stats():
    return {
        "users": 1200,
        "revenue": 5000,
        "videos": 3200  
    }
@app.route("/process", methods=["POST"])
def process():

    # audio → texte → voix → vidéo
    return {"status": "done"}
@app.route("/talking-photo", methods=["POST"])
def talking_photo():

    image = request.files["image"]
    text = request.form["text"]

    # 1 voix
    audio = generate_voice(text)

    # 2 vidéo parlante
    video = create_talking_photo(image.filename, audio)

    return {"video": video}