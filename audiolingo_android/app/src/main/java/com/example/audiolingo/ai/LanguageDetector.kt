package com.example.audiolingo.ai

class LanguageDetector {

    fun detectLanguage(text: String): String {
    val t = text.lowercase()

    return when {
        // Top langues
        t.contains("the") -> "en"
        t.contains("le ") || t.contains("la ") -> "fr"
        t.contains("el ") -> "es"
        t.contains("der ") || t.contains("die ") -> "de"
        t.contains("il ") -> "it"
        t.contains("de ") -> "pt"
        t.contains("een ") -> "nl"
        t.contains("och ") -> "sv"
        t.contains("og ") -> "no"
        t.contains("ja ") -> "fi"

        // Europe
        t.contains("jest ") -> "pl"
        t.contains("je ") -> "cs"
        t.contains("že ") -> "sk"
        t.contains("és ") -> "hu"
        t.contains("și ") -> "ro"
        t.contains("е ") -> "bg"
        t.contains("da ") -> "sr"
        t.contains("je ") -> "hr"
        t.contains("është ") -> "sq"
        t.contains("është ") -> "sq"

        // Afrique
        t.contains("na ") -> "yo" // Yoruba
        t.contains("ni ") -> "sw" // Swahili
        t.contains("da ") -> "ha" // Hausa
        t.contains("ne ") -> "ig" // Igbo
        t.contains("ak ") -> "tw" // Twi
        t.contains("ku ") -> "wo" // Wolof

        // Asie
        t.contains("是") -> "zh"
        t.contains("です") -> "ja"
        t.contains("입니다") -> "ko"
        t.contains("है") -> "hi"
        t.contains("ہے") -> "ur"
        t.contains("adalah") -> "id"
        t.contains("ay ") -> "tl"
        t.contains("là ") -> "vi"
        t.contains("คือ") -> "th"

        // Moyen-Orient
        t.contains("ال") -> "ar"
        t.contains("של") -> "he"
        t.contains("است") -> "fa"
        t.contains("dir ") -> "tr"

        // Autres (exemples jusqu’à 100)
        t.contains("este ") -> "gl"
        t.contains("questo ") -> "it"
        t.contains("det ") -> "da"
        t.contains("það ") -> "is"
        t.contains("þetta ") -> "is"
        t.contains("ta ") -> "bn"
        t.contains("මෙම") -> "si"
        t.contains("នេះ") -> "km"
        t.contains("ຄື") -> "lo"
        t.contains("ནི") -> "bo"
        else -> "unknown"
        }
    }
}