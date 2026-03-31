use crate::commands::Intent;
use crate::context::ConversationContext;
use std::time::{SystemTime, UNIX_EPOCH};

pub fn generate_response(intent: &Intent, _context: &ConversationContext) -> String {
    match intent {
        Intent::Greeting => "Bonjour ! Comment puis-je vous aider ?".to_string(),

        Intent::GetTime => {
            let now = SystemTime::now()
                .duration_since(UNIX_EPOCH)
                .unwrap()
                .as_secs();
            format!("Temps Unix actuel : {}", now)
        }

        Intent::Unknown => "Je n'ai pas compris.".to_string(),
    }
}