from fastapi import APIRouter
from database import SessionLocal
from models.user import User

router = APIRouter()

@router.get("/admin/users")
def get_users():
    db = SessionLocal()
    return db.query(User).all()