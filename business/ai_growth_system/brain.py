import json
import random

TOPICS = [
    "gagner argent avec IA",
    "sous-titres automatiques",
    "voix IA réaliste",
    "créer chaîne youtube sans parler"
]

def choose_topic():
    return random.choice(TOPICS)

def save_result(data):
    with open("database.json", "r+") as f:
        db = json.load(f)
        db.append(data)
        f.seek(0)
        json.dump(db, f)

print("🧠 IA prête")