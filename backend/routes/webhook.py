from fastapi import APIRouter, Request
from database.db import SessionLocal
from models.user import User

router = APIRouter()

@router.post("/webhook/cinetpay")
async def cinetpay_webhook(req: Request):
    data = await req.json()

    email = data.get("customer_email")  # ⚠️ important

    db = SessionLocal()
    user = db.query(User).filter(User.email == email).first()

    if user:
        user.is_premium = True
        db.commit()

    return {"status": "premium activated"}