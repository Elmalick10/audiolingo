from fastapi import FastAPI
from routes import ai, webhook, webhook_paypal

app = FastAPI()

# ROUTES
app.include_router(ai.router)
app.include_router(webhook.router)
app.include_router(webhook_paypal.router)

# ROUTE TEST
@app.get("/")
def home():
    return {"message": "AudioLingo API OK"}

# ROUTE HEALTH
@app.get("/health")
def health():
    return {"status": "ok"}