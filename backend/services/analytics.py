import sqlite3

def calculate_mrr():

    conn = sqlite3.connect("C:\\audiolingo\\backend\\database\\db.sqlite")
    cur = conn.cursor()

    cur.execute("""
    SELECT COUNT(*) FROM subscriptions WHERE status='active'
    """)

    users = cur.fetchone()[0]

    return users * 10  # exemple 10€/mois