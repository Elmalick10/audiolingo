import com.arthenica.ffmpegkit.FFmpegKit

fun exportVideo(input: String, output: String, subtitles: String) {

    val cmd = "-i $input -vf subtitles=$subtitles -c:a copy $output"

    FFmpegKit.executeAsync(cmd) { session ->
        println("Export terminé : ${session.returnCode}")
    }
}