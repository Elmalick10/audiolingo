from jose import jwt

SECRET = "SECRET"

def create_token(data):
    return jwt.encode(data, SECRET, algorithm="HS256")