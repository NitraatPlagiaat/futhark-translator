package org.example.models.mapping

import controllers.skipLetter
import models.phonetics.graphemes

val romanToFuthark = mapOf(
    "a" to "Ansuz",
    "b" to "Berkanan",
    "c" to "Kauna",
    "d" to "Dagaz",
    "e" to "Ehwaz",
    "f" to "Fehu",
    "g" to "Gebo",
    "h" to "Haglaz",
    "i" to "Isaz",
    "j" to "Jeran",
    "k" to "Kauna",
    "l" to "Laukaz",
    "m" to "Mannaz",
    "n" to "Naudiz",
    "o" to "Othalan",
    "p" to "Pertho",
    "q" to "Kauna",
    "r" to "Raido",
    "s" to "Sowilo",
    "t" to "Tiwaz",
    "u" to "Uruz",
    "v" to "Wunjo",
    "w" to "Wunjo",
    "x" to "Sowilo",
    "y" to "Iwaz",
    "z" to "Algiz",
    "ng" to "Ingwaz",
    "th" to "Thurisaz"
)

val vowels = arrayOf('a', 'e', 'i', 'o', 'u')

fun getCorrespondingRune(text: String, index: Int): Char? {
    var letter = text[index].toString()
    if (index + 1 < text.length) {
        if (letter == "n" && text[index + 1] == 'g') {
            letter = "ng"
            skipLetter = true
        }
        if (letter == "t" && text[index + 1] == 'h') {
            letter = "th"
            skipLetter = true
        }
    }
    val runeName: String = romanToFuthark[letter] ?: return null
    return getRune(runeName)
}

fun checkWritingRules(text: String, index: Int): Char? {
    val standardRune = getCorrespondingRune(text, index)
    var rune: Char? = null
    if (index + 1 < text.length) {
        if (graphemes.containsKey(text[index].toString())) {
            rune = graphemes[text[index].toString()]?.invoke(text, index)
        }
        if (text[index] in vowels) {
            rune = checkExtraVowel(text, index, rune)
            if (rune != null) {
                skipLetter = true
            }
        }
    }
    if (rune != null) {
        return rune
    }
    return standardRune
}