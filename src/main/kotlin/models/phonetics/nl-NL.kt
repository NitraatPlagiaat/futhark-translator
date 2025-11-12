package models.phonetics

import models.vowels
import models.elderFutharkRunes
import controllers.skipLetter
var graphemes = mapOf(
    "c" to { input: String, index: Int -> getPhoneticForC(input, index) },
    "y" to { input: String, index: Int -> getPhoneticForY(input, index) }
)

fun getPhoneticForC(input: String, index : Int): Char? {
    if (input[index+1] == 'h') {
        skipLetter = true
        return elderFutharkRunes["Gebo"]
    }
    if (input[index+1] == 'k') {
        skipLetter = true
        return elderFutharkRunes["Kauna"]
    }
    return null
}

fun getPhoneticForY(input: String, index: Int): Char? {
    if (input[index+1] in vowels) {
        return elderFutharkRunes["Jeran"]
    }
    return null
}