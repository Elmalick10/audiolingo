use tokio::sync::mpsc;

pub async fn start_pipeline() {
    let (tx, mut rx) = mpsc::channel::<String>(32);

    tokio::spawn(async move {
        tx.send("bonjour".into()).await.unwrap();
    });

    while let Some(text) = rx.recv().await {
        println!("Texte reçu: {}", text);
    }
}