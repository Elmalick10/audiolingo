import requests

def create_payment(user_id, amount):

    payload = {
        "amount": amount,
        "currency": "XOF",
        "transaction_id": user_id,
        "return_url": "http://localhost:5000/payment-success"
    }

    r = requests.post("https://api-checkout.cinetpay.com/v2/payment", json=payload)

    return r.json()