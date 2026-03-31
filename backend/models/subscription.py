def create_table():

    import sqlite3

    conn = sqlite3.connect("C:\\audiolingo\\backend\\database\\db.sqlite")
    cur = conn.cursor()

    cur.execute("""
    CREATE TABLE IF NOT EXISTS subscriptions (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        user_id INTEGER,
        plan TEXT,
        status TEXT,
        start_date TEXT,
        end_date TEXT,
        auto_renew INTEGER
    )
    """)

    conn.commit()