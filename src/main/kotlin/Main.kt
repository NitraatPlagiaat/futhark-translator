package org.example
import models.printFuthark
import controllers.input

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    printFuthark()
    while (true) {

        print("Write text to convert to Elder Futhark: ")

        val text: String = readln()

        input(text.lowercase())
    }
}