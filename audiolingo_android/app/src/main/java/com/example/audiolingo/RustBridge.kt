object RustBridge {
    init {
        System.loadLibrary("audiolingo_core")
    }

    external fun hello_from_rust(): String
}