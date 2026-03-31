package com.example.audiolingo

object SubtitleGenerator {

    fun generate(words: List<Pair<String, Long>>): String {

        val sb = StringBuilder()
        var index = 1

        for ((word, time) in words) {

            val start = format(time)
            val end = format(time + 2000)

            sb.append("$index\n")
            sb.append("$start --> $end\n")
            sb.append("$word\n\n")

            index++
        }

        return sb.toString()
    }

    private fun format(ms: Long): String {
        val sec = ms / 1000
        val min = sec / 60
        val s = sec % 60
        return String.format("00:%02d:%02d,000", min, s)
    }
}