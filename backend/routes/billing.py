from fastapi import APIRouter, HTTPException
import requests
from config.payment import *

router = APIRouter(prefix="/billing", tags=["Billing"])

PLANS = {
    "premium": 5,
    "pro": 15,
    "enterprise": 49
}

# 💳 CinetPay paiement
@router.post("/pay/cinetpay")
def pay_cinetpay(email: str, plan: str):

    if plan not in PLANS:
        raise HTTPException(400, "Invalid plan")

    data = {
        "apikey": CINETPAY_API_KEY,
        "site_id": CINETPAY_SITE_ID,
        "amount": PLANS[plan],
        "currency": "USD",
        "description": f"Plan {plan}",
        "customer_email": email
    }

    return {
        "status": "pending",
        "payment_gateway": "CinetPay",
        "data": data
    }


# 💳 PAYPAL paiement réel
@router.post("/pay/paypal")
def pay_paypal(plan: str):

    if plan not in PLANS:
        raise HTTPException(400, "Invalid plan")

    return {
        "approval_url": f"https://www.paypal.com/checkoutnow?plan={plan}"
    }