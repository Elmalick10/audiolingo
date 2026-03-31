use reqwest::Client;
use crate::{error::Result, types::Language};

pub struct Translator {
    client: Client,
}

impl Translator {
    pub fn new() -> Result<Self> {
        Ok(Self {
            client: Client::new(),
        })
    }

    pub async fn translate(&self, text: &str, to: Language) -> Result<String> {
        let res = self.client
            .post("https://libretranslate.de/translate")
            .json(&serde_json::json!({
                "q": text,
                "source": "auto",
                "target": to.code(),
                "format": "text"
            }))
            .send()
            .await?
            .json::<serde_json::Value>()
            .await?;

        Ok(res["translatedText"].as_str().unwrap().to_string())
    }
}