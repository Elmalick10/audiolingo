use super::participant::Participant;

pub struct ConferenceSession {
    participants: Vec<Participant>,
}

impl ConferenceSession {
    pub fn new() -> Self {
        Self {
            participants: Vec::new(),
        }
    }

    pub fn add(&mut self, p: Participant) {
        self.participants.push(p);
    }

    pub fn list(&self) {
        for p in &self.participants {
            println!("{} parle {}", p.name, p.language);
        }
    }
}