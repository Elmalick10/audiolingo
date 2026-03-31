import sqlite3
from datetime import datetime, timedelta
from services.payment import create_payment

DB = "C:\\audiolingo\\backend\\database\\db.sqlite"

def check_renewals():

    conn = sqlite3.connect(DB)
    cur = conn.cursor()

    cur.execute("SELECT * FROM subscriptions WHERE auto_renew=1")

    subs = cur.fetchall()

    for sub in subs:

        end_date = datetime.fromisoformat(sub[5])

        if datetime.now() >= end_date:

            print(f"🔁 Renouvellement user {sub[1]}")

            result = create_payment(sub[1], 10)

            if result:
                new_end = datetime.now() + timedelta(days=30)

                cur.execute("""
                UPDATE subscriptions
                SET end_date=?
                WHERE id=?
                """, (new_end, sub[0]))

            else:
                # ❌ paiement échoué
                cur.execute("""
                UPDATE subscriptions
                SET status='inactive'
                WHERE id=?
                """, (sub[0],))

    conn.commit()