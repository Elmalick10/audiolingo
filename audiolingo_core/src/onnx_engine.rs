use ort::{Environment, SessionBuilder};

pub fn load_model(path: &str) {

    let env = Environment::builder()
        .with_name("audiolingo")
        .build()
        .unwrap();

    let _session = SessionBuilder::new(&env)
        .unwrap()
        .with_model_from_file(path)
        .unwrap();

}