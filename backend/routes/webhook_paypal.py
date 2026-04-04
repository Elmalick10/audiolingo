from fastapi import APIRouter, Request
from services.subscription_service import activate_subscription

router = APIRouter()

@router.post("/webhook/paypal")
async def paypal_webhook(request: Request):
    data = await request.json()

    if data.get("event_type") == "PAYMENT.SALE.COMPLETED":
        user_id = data["resource"]["custom_id"]
        activate_subscription(user_id)

    return {"status": "ok"}