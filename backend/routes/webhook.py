from fastapi import APIRouter, Request
from services.subscription_service import activate_subscription

router = APIRouter()

@router.post("/webhook/cinetpay")
async def cinetpay_webhook(request: Request):
    data = await request.json()

    if data.get("status") == "ACCEPTED":
        user_id = data.get("customer_id")
        activate_subscription(user_id)

    return {"status": "ok"}