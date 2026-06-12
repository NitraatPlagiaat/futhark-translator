package models.phonetics

import models.vowels
import models.elderFutharkRunes
import controllers.skipLetter
var graphemes = mapOf(
    "c" to { input: String, index: Int -> getPhoneticForC(input, index) },
    "e" to { input: String, index: Int -> getPhoneticForE(input, index) },
    "i" to { input: String, index: Int -> getPhoneticForI(input, index) },
    "y" to { input: String, index: Int -> getPhoneticForY(input, index) }
)

fun getPhoneticForC(input: String, index: Int): Char? {
    if (input[index+1] == 'h' && input[index-1] == 's') {
        skipLetter = true
        return elderFutharkRunes["Gebo"]
    }
    if (input[index+1] == 'k') {
        skipLetter = true
        return elderFutharkRunes["Kauna"]
    }
    if (input[index+1] == 'i') {
        return elderFutharkRunes["Sowilo"]
    }
    return null
}

fun getPhoneticForE(input: String, index: Int): Char? {
    if (input[index+1] == 'i') {
        skipLetter = true
        return elderFutharkRunes["Iwaz"]
    }
    return null
}

fun getPhoneticForI(input: String, index: Int): Char? {
    if (input[index+1] == 'j') {
        skipLetter = true
        return elderFutharkRunes["Iwaz"]
    }
    return null
}

fun getPhoneticForY(input: String, index: Int): Char? {
    if (input[index+1] in vowels) {
        return elderFutharkRunes["Jeran"]
    }
    if (input[index+1] == 'n') {
        return elderFutharkRunes["Isaz"]
    }
    return null
}