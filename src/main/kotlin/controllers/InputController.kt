package controllers
import org.example.models.mapping.checkWritingRules

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