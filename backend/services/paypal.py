import requests
from config.payment_config import *

def get_access_token():

    url = "https://api-m.sandbox.paypal.com/v1/oauth2/token"

    response = requests.post(
        url,
        headers={"Accept": "application/json"},
        data={"grant_type": "client_credentials"},
        auth=(PAYPAL_CLIENT_ID, PAYPAL_SECRET)
    )

    return response.json()["access_token"]


def create_payment(amount):

    token = get_access_token()

    url = "https://api-m.sandbox.paypal.com/v2/checkout/orders"

    headers = {
        "Content-Type": "application/json",
        "Authorization": f"Bearer {token}"
    }

    data = {
        "intent": "CAPTURE",
        "purchase_units": [{
            "amount": {
                "currency_code": "USD",
                "value": str(amount)
            }
        }]
    }

    response = requests.post(url, json=data, headers=headers)

    return response.json()