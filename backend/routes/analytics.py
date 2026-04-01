from fastapi import APIRouter
from database import SessionLocal
from models.user import User
from models.payment import Payment

router = APIRouter()

@router.get("/analytics")
def analytics():
    db = SessionLocal()

    users = db.query(User).count()
    payments = db.query(Payment).all()

    revenue = sum(p.amount for p in payments if p.status == "paid")

    return {
        "users": users,
        "revenue": revenue,
        "payments": len(payments)
    }