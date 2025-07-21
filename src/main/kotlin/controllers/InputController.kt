package controllers

import models.getCorrespondingRune
import models.checkExtraVowel
import models.vowels

var skipLetter = false

fun input(text: String) {
    var futharkConversion = ""
    for (letter in text.indices) {

        if (skipLetter){
            skipLetter = false
            continue
        }

        if (text[letter] == ' ') {
            futharkConversion += " "
        }
        else {
            if (text[letter] in 'a'..'z') {
                futharkConversion += checkWritingRules(text, letter)
            }
        }
    }
    println(futharkConversion)
}

fun checkWritingRules(text: String, index: Int): Char? {
    val standardRune = getCorrespondingRune(text[index])
    if (text[index] in vowels) {
        val rune = checkExtraVowel(text, index)
        if (rune != null) {
            skipLetter = true
            return rune
        }
    }

    return standardRune
}