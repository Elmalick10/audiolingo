from fastapi import APIRouter
from database.db import SessionLocal
from models.user import User

router = APIRouter()

@router.get("/admin/stats")
def stats():
    db = SessionLocal()

    total_users = db.query(User).count()
    premium_users = db.query(User).filter(User.is_premium == True).count()

    return {
        "total_users": total_users,
        "premium_users": premium_users
    }