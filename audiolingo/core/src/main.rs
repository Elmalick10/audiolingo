use audiolingo_core::Pipeline;
use tokio;

#[tokio::main]
async fn main() {
    let pipeline = Pipeline::new().await.unwrap();
    pipeline.run().await.unwrap();
}