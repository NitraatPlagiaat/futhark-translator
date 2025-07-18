package controllers

import models.getCorrespondingRune

fun input(text: String) {
    var futharkConversion = ""
    for (letter in text) {
        if (letter == ' ') {
            futharkConversion += " "
        }
        else {
            if (letter in 'a'..'z') futharkConversion += getCorrespondingRune(letter)
        }
    }
    println(futharkConversion)
}