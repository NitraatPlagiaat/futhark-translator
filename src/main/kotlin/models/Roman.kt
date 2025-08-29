package models

import controllers.skipLetter

val romanToFuthark = mapOf(
    'a' to "Ansuz",
    'b' to "Berkanan",
    'c' to "Kauna",
    'd' to "Dagaz",
    'e' to "Ehwaz",
    'f' to "Fehu",
    'g' to "Gebo",
    'h' to "Haglaz",
    'i' to "Isaz",
    'j' to "Jeran",
    'k' to "Kauna",
    'l' to "Laukaz",
    'm' to "Mannaz",
    'n' to "Naudiz",
    'o' to "Othalan",
    'p' to "Pertho",
    'q' to "Kauna",
    'r' to "Raido",
    's' to "Sowilo",
    't' to "Tiwaz",
    'u' to "Uruz",
    'v' to "Fehu",
    'w' to "Wunjo",
    'x' to "Sowilo",
    'y' to "Iwaz",
    'z' to "Algiz"
)

val vowels = arrayOf('a', 'e', 'i', 'o', 'u')

fun getCorrespondingRune(letter: Char): Char? {
    val runeName: String = romanToFuthark[letter] ?: return null
    return getRune(runeName)
}

fun checkWritingRules(text: String, index: Int): Char? {
    val standardRune = getCorrespondingRune(text[index])
    var rune: Char? = null
    if (text[index] in vowels) {
        rune = checkExtraVowel(text, index)
    } else {
        rune = checkAlternates(text, index)
    }
    if (rune != null) {
        skipLetter = true
        return rune
    }
    return standardRune
}