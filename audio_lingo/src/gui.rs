use eframe::egui;

pub struct AudioLingoApp {
    pub status: String,
}

impl Default for AudioLingoApp {
    fn default() -> Self {
        Self {
            status: "Prêt".into(),
        }
    }
}

impl eframe::App for AudioLingoApp {
    fn update(&mut self, ctx: &egui::Context, _frame: &mut eframe::Frame) {
        egui::CentralPanel::default().show(ctx, |ui| {
            ui.heading("🎧 AudioLingo");
            ui.label(format!("Statut: {}", self.status));

            if ui.button("Démarrer").clicked() {
                self.status = "Écoute...".into();
            }

            if ui.button("Stop").clicked() {
                self.status = "Arrêté".into();
            }
        });
    }
}