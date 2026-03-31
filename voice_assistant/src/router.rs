use crate::commands::{detect_command, Command};
use crate::context::ConversationMemory;

pub fn route(text: &str, memory: &mut ConversationMemory) -> String {
    match detect_command(text) {
        Command::Repeat => memory.last().cloned().unwrap_or("Rien à répéter".into()),
        Command::Translate => format!("Traduction demandée: {}", text),
        Command::Unknown => format!("Commande inconnue: {}", text),
    }
}