from fastapi import Header
from auth.jwt_handler import decode_token
from auth.dependencies import get_current_user

@router.get("/protected")
def protected(user=Depends(get_current_user)):
    return {"user": user}

def get_current_user(authorization: str = Header(...)):
    token = authorization.split(" ")[1]
    return decode_token(token)