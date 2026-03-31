from googleapiclient.discovery import build
from googleapiclient.http import MediaFileUpload

API_KEY = "TA_CLE_API"

youtube = build("youtube", "v3", developerKey=API_KEY)

request = youtube.videos().insert(
    part="snippet,status",
    body={
        "snippet": {
            "title": "🔥 IA sous-titres automatiques",
            "description": "Créé avec AudioLingo",
            "tags": ["ai", "subtitle", "automation"],
            "categoryId": "22"
        },
        "status": {
            "privacyStatus": "public"
        }
    },
    media_body=MediaFileUpload("content/video1.mp4")
)

response = request.execute()
print("✅ Vidéo YouTube postée")