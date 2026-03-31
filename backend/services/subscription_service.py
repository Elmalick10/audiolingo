import sqlite3
from datetime import datetime, timedelta

DB = "C:\\audiolingo\\backend\\database\\db.sqlite"

def create_subscription(user_id, plan):

    conn = sqlite3.connect(DB)
    cur = conn.cursor()

    start = datetime.now()
    end = start + timedelta(days=30)

    cur.execute("""
    INSERT INTO subscriptions (user_id, plan, status, start_date, end_date, auto_renew)
    VALUES (?, ?, ?, ?, ?, ?)
    """, (user_id, plan, "active", start, end, 1))

    conn.commit()


def get_active_subscription(user_id):

    conn = sqlite3.connect(DB)
    cur = conn.cursor()

    cur.execute("""
    SELECT * FROM subscriptions 
    WHERE user_id=? AND status='active'
    """, (user_id,))

    return cur.fetchone()