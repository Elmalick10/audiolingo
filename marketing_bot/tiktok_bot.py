from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
import time
import os

VIDEO_PATH = "content/video1.mp4"
CAPTION = "🔥 Sous-titres automatiques avec IA #ai #tiktok"

driver = webdriver.Chrome(ChromeDriverManager().install())
driver.get("https://www.tiktok.com/upload")

input("👉 Connecte-toi puis appuie sur ENTER...")

time.sleep(5)

# Upload vidéo
upload_input = driver.find_element(By.XPATH, '//input[@type="file"]')
upload_input.send_keys(os.path.abspath(VIDEO_PATH))

time.sleep(10)

# Caption
caption_box = driver.find_element(By.XPATH, '//div[@contenteditable="true"]')
caption_box.send_keys(CAPTION)

time.sleep(5)

# Bouton publier
post_btn = driver.find_element(By.XPATH, '//button[contains(., "Post")]')
post_btn.click()

print("✅ Vidéo TikTok postée")