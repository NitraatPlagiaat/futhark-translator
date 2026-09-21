package models.phonetics

import org.example.models.mapping.vowels
import org.example.models.mapping.elderFutharkRunes
import controllers.skipLetter
var graphemes = mapOf(
    "c" to { input: String, index: Int -> getPhoneticForC(input, index) },
    "e" to { input: String, index: Int -> getPhoneticForE(input, index) },
    "i" to { input: String, index: Int -> getPhoneticForI(input, index) },
    "y" to { input: String, index: Int -> getPhoneticForY(input, index) }
)

fun getPhoneticForC(input: String, index: Int): Char? {
    when (input[index + 1]) {
        'h' -> when (input[index - 1]) {
            's' -> {
                skipLetter = true
                return elderFutharkRunes["Gebo"]
            }
        }

        'k' -> {
            skipLetter = true
            return elderFutharkRunes["Kauna"]
        }

        'i' -> return elderFutharkRunes["Sowilo"]
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
    when (input[index + 1]) {
        in vowels -> return elderFutharkRunes["Jeran"]
        'n' -> return elderFutharkRunes["Isaz"]
    }
    return null
}