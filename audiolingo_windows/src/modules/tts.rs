use anyhow::Result;
use windows::{
    core::*,
    Win32::System::Com::*,
    Win32::System::Speech::*,
};

pub struct TextToSpeech {
    voice: ISpVoice,
}

impl TextToSpeech {
    pub fn new() -> Result<Self> {
        unsafe {
            CoInitializeEx(std::ptr::null_mut(), COINIT_APARTMENTTHREADED)?;
            let voice: ISpVoice = CoCreateInstance(&SpVoice, None, CLSCTX_ALL)?;
            Ok(Self { voice })
        }
    }

    pub fn speak(&self, text: &str) -> Result<()> {
        unsafe {
            let wide: Vec<u16> = text.encode_utf16().chain(Some(0)).collect();
            self.voice.Speak(
                PCWSTR(wide.as_ptr()),
                SPF_DEFAULT,
                std::ptr::null_mut(),
            )?;
        }
        Ok(())
    }
}