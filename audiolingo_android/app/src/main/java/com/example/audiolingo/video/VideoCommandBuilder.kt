package com.example.audiolingo.video

object VideoCommandBuilder {

    fun cut(input: String, start: Int, duration: Int, output: String): Array<String> {
        return arrayOf(
            "-y",
            "-i", input,
            "-ss", start.toString(),
            "-t", duration.toString(),
            "-c", "copy",
            output
        )
    }

    fun zoom(input: String, output: String): Array<String> {
        return arrayOf(
            "-i", input,
            "-vf", "zoompan=z='min(zoom+0.0015,1.5)':d=125",
            output
        )
    }
}