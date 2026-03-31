fn main() {
    println!("cargo:rustc-link-search=native=C:/audiolingo/whisper.cpp/build");
    println!("cargo:rustc-link-lib=static=whisper");
}