from fastapi import APIRouter
from security.jwt import create_token

router = APIRouter(prefix="/auth")

@router.post("/login")
def login(email: str, password: str):

    token = create_token({"email": email})

    return {
        "status": "ok",
        "token": token
    }