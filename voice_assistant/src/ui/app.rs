use eframe::egui;
use crate::pipeline::Pipeline;
use crate::lang::Language;

pub struct AudioLingoApp {
    pipeline: Pipeline,
    input_text: String,
    output_text: String,
    target_lang: Language,
}

impl Default for AudioLingoApp {
    fn default() -> Self {
        Self {
            pipeline: Pipeline::new(),
            input_text: String::new(),
            output_text: String::new(),
            target_lang: Language::EN,
        }
    }
}

impl eframe::App for AudioLingoApp {
    fn update(&mut self, ctx: &egui::Context, _: &mut eframe::Frame) {
        egui::CentralPanel::default().show(ctx, |ui| {
            ui.heading("🎙 AudioLingo");

            ui.label("Texte source");
            ui.text_edit_multiline(&mut self.input_text);

            if ui.button("Traduire").clicked() {
                self.output_text = self.pipeline.translate_text(
                    &self.input_text,
                    self.target_lang,
                );
            if ui.button("🎬 Mode universel").clicked() {
    println!("Capture audio système activée");
}

            ui.separator();

            ui.label("Traduction");
            ui.text_edit_multiline(&mut self.output_text);
        });
    }
}