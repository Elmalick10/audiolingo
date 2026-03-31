import requests

API_URL = "http://127.0.0.1:1234/v1/chat/completions"

def generate_content(prompt):

    data = {
        "model": "local-model",
        "messages": [
            {"role": "system", "content": """
Tu es une IA qui crée du contenu viral RESPECTUEUX.
Interdiction:
- haine
- religion attaquée
- politique extrême
- violence

Objectif:
- inspirer
- éduquer
- divertir
"""},
            {"role": "user", "content": prompt}
        ]
    }

    r = requests.post(API_URL, json=data)
    return r.json()["choices"][0]["message"]["content"]