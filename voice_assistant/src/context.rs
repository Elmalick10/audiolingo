use std::collections::VecDeque;

pub struct ConversationMemory {
    history: VecDeque<String>,
    max_size: usize,
}

impl ConversationMemory {
    pub fn new() -> Self {
        Self {
            history: VecDeque::new(),
            max_size: 10,
        }
    }

    pub fn add(&mut self, msg: String) {
        if self.history.len() >= self.max_size {
            self.history.pop_front();
        }
        self.history.push_back(msg);
    }

    pub fn last(&self) -> Option<&String> {
        self.history.back()
    }
}