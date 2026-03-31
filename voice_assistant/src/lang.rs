#[derive(Debug, Clone, Copy)]
pub enum Language {
    EN, ZH, HI, ES, FR, AR, BN, PT, RU, UR,
    ID, DE, JA, SW, MR, TE, TR, KO, VI, IT,
}

impl Language {
    pub fn code(&self) -> &'static str {
        match self {
            Language::EN => "en",
            Language::ZH => "zh",
            Language::HI => "hi",
            Language::ES => "es",
            Language::FR => "fr",
            Language::AR => "ar",
            Language::BN => "bn",
            Language::PT => "pt",
            Language::RU => "ru",
            Language::UR => "ur",
            Language::ID => "id",
            Language::DE => "de",
            Language::JA => "ja",
            Language::SW => "sw",
            Language::MR => "mr",
            Language::TE => "te",
            Language::TR => "tr",
            Language::KO => "ko",
            Language::VI => "vi",
            Language::IT => "it",
        }
    }
}