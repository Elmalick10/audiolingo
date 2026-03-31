from flask import request
import sqlite3

DB = "C:\\audiolingo\\backend\\database\\db.sqlite"

def change_plan():

    data = request.json
    user_id = data["user_id"]
    new_plan = data["plan"]

    conn = sqlite3.connect(DB)
    cur = conn.cursor()

    cur.execute("""
    UPDATE subscriptions
    SET plan=?
    WHERE user_id=? AND status='active'
    """, (new_plan, user_id))

    conn.commit()

    return {"status": "updated"}