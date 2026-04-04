from fastapi import APIRouter
from auth.jwt_handler import create_token
from auth.security import hash_password, verify_password
from database.db import SessionLocal
from models.user import User

router = APIRouter()

@router.post("/register")
def register(data: dict):
    db = SessionLocal()

    user = User(
        email=data["email"],
        password=hash_password(data["password"])
    )

    db.add(user)
    db.commit()

    return {"message": "user created"}

@router.post("/login")
def login(data: dict):
    db = SessionLocal()

    user = db.query(User).filter(User.email == data["email"]).first()

    if not user or not verify_password(data["password"], user.password):
        return {"error": "invalid credentials"}

    token = create_token({"user_id": user.id})

    return {"token": token}