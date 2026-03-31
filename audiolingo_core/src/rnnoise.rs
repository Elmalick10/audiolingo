extern "C" {
    fn rnnoise_create() -> *mut std::ffi::c_void;
    fn rnnoise_process_frame(
        st: *mut std::ffi::c_void,
        out: *mut f32,
        input: *const f32
    ) -> f32;
}

pub fn denoise(frame: &mut [f32]) {

    for sample in frame.iter_mut() {
        *sample *= 0.95;
    }

}