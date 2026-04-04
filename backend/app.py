from fastapi import FastAPI, Request

app = FastAPI()

# 🔥 Route test
@app.get("/")
def home():
    return {"status": "AudioLingo API running 🚀"}

# 🔥 Pipeline IA (simulation pour l'instant)
@app.post("/ai/process")
async def process_ai(request: Request):
    data = await request.json()

    text = data.get("text", "")

    # ⚡ ici tu brancheras ton IA plus tard
    result = text.upper()

    return {
        "input": text,
        "output": result,
        "status": "processed"
    }

# 💳 Webhook CinetPay
@app.post("/webhook/cinetpay")
async def cinetpay_webhook(request: Request):
    data = await request.json()

    print("CinetPay webhook reçu :", data)

    # TODO : activer abonnement
    return {"status": "ok"}

# 💳 Webhook PayPal
@app.post("/webhook/paypal")
async def paypal_webhook(request: Request):
    data = await request.json()

    print("PayPal webhook reçu :", data)

    # TODO : activer abonnement
    return {"status": "ok"}