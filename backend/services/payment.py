import requests

def create_payment(user_id, amount):

    url = "https://api-checkout.cinetpay.com/v2/payment"

    data = {
        "amount": amount,
        "currency": "XOF",
        "description": "Abonnement AudioLingo"
    }

    r = requests.post(url, json=data)
    return r.json()