from fastapi import APIRouter, Request
from services.ai_pipeline import process_pipeline

router = APIRouter(prefix="/ai")

@router.post("/process")
async def process_ai(request: Request):
    data = await request.json()

    text = data.get("text", "")

    result = await process_pipeline(text)

    return result