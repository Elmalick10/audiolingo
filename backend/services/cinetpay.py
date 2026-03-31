import requests
from config.payment_config import *

def create_cinetpay_payment(amount, transaction_id):

    url = "https://api-checkout.cinetpay.com/v2/payment"

    data = {
        "apikey": CINETPAY_API_KEY,
        "site_id": CINETPAY_SITE_ID,
        "transaction_id": transaction_id,
        "amount": amount,
        "currency": "XOF",
        "description": "Abonnement AudioLingo",
        "return_url": BASE_URL + "/payment-success",
        "notify_url": BASE_URL + "/payment-notify"
    }

    response = requests.post(url, json=data)

    return response.json()