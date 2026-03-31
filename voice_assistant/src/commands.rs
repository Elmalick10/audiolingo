pub enum Command {
    Translate,
    Repeat,
    Unknown,
}

pub fn detect_command(text: &str) -> Command {
    if text.contains("répète") {
        Command::Repeat
    } else if text.contains("traduis") {
        Command::Translate
    } else {
        Command::Unknown
    }
}