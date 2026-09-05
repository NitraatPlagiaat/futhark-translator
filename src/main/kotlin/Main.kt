package org.example
import org.example.models.mapping.printFuthark
import controllers.input
import java.lang.NumberFormatException
import kotlin.system.exitProcess

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    print("Welcome to Rúnatýr\n")
    println()
    while (true) {

        print("""Make a choice:
            |1: Convert from alphabet to runes (Elder Futhark)
            |2: Show the Elder Futhark runes
            |3: About
            |4: Exit program
            |
        """.trimMargin())
        print("Enter your choice: ")

        val choice: Int = try {
            readln().toInt()
        } catch(e: NumberFormatException) {
            0
        }

        when (choice) {
            1 -> alphabetToRunes()
            2 -> printFuthark()
            3 -> "Not implemented yet"
            4 -> exitProcess(0)
            else -> print("You didn't type in a number\n\n")
        }
    }
}

fun alphabetToRunes() {
    print("You are now converting alphabet to runes. To go back to the main menu, type ~\n")
    while (true) {
        print("Write text to convert to Elder Futhark: ")

        val text: String = readln()

        if (text == "~") { break }

        input(text.lowercase())
    }
}