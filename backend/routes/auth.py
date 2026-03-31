from flask import request, jsonify
import sqlite3

def register():

    data = request.json

    conn = sqlite3.connect("C:\\audiolingo\\backend\\database\\db.sqlite")
    cur = conn.cursor()

    cur.execute("INSERT INTO users (email, password) VALUES (?, ?)",
                (data["email"], data["password"]))

    conn.commit()

    return jsonify({"status": "ok"})

def login():

    data = request.json

    conn = sqlite3.connect("C:\\audiolingo\\backend\\database\\db.sqlite")
    cur = conn.cursor()

    cur.execute("SELECT * FROM users WHERE email=? AND password=?",
                (data["email"], data["password"]))

    user = cur.fetchone()

    if user:
        return jsonify({"status": "ok", "user_id": user[0]})
    else:
        return jsonify({"status": "error", "message": "Invalid credentials"})
