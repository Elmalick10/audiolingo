from flask import request

def payment_notify():

    data = request.json

    print("💰 Paiement reçu:", data)

    # activer abonnement utilisateur ici

    return "OK"

def activate_subscription(user_id):

    print(f"Utilisateur {user_id} activé")