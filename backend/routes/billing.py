from flask import request, jsonify
from services.paypal import create_payment
from services.cinetpay import create_cinetpay_payment
import uuid

def pay():

    data = request.json

    method = data["method"]  # paypal ou cinetpay
    amount = data["amount"]

    if method == "paypal":

        result = create_payment(amount)
        return jsonify(result)

    elif method == "cinetpay":

        transaction_id = str(uuid.uuid4())
        result = create_cinetpay_payment(amount, transaction_id)

        return jsonify(result)

    return jsonify({"error": "Méthode invalide"})
