ui.horizontal(|ui| {
    if ui.button("🎬 Mode universel").clicked() {
        println!("Mode universel activé");
    }
    if ui.button("🧠 Assistant").clicked() {
        println!("Assistant contextuel activé");
    }
    if ui.button("🎙 Temps réel").clicked() {
        println!("Pipeline temps réel activé");
    }
    if ui.button("⚡ Optimiser").clicked() {
        println!("Optimisation CPU activée");
    }
});