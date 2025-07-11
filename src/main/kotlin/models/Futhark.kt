package models

import kotlin.collections.iterator

val elderFutharkRunes = mapOf<String, Char>(
    "Fehu" to '\u16A0',
    "Uruz" to '\u16A2',
    "Thurisaz" to '\u16A6',
    "Ansuz" to '\u16A8',
    "Raido" to '\u16B1',
    "Kauna" to '\u16B2',
    "Gebo" to '\u16B7',
    "Wunjo" to '\u16B9',
    "Haglaz" to '\u16BA',
    "Naudiz" to '\u16BE',
    "Isaz" to '\u16C1',
    "Jeran" to '\u16C3',
    "Iwaz" to '\u16C7',
    "Pertho" to '\u16C8',
    "Algiz" to '\u16C9',
    "Sowilo" to '\u16CA',
    "Tiwaz" to '\u16CF',
    "Berkanan" to '\u16D2',
    "Ehwaz" to '\u16D6',
    "Mannaz" to '\u16D7',
    "Laukaz" to '\u16DA',
    "Ingwaz" to '\u16DC',
    "Dagaz" to '\u16DE',
    "Othalan" to '\u16DF'
)

fun printFuthark() {
    println("The Elder Futhark runes:")
    for (rune in elderFutharkRunes) {
        print(rune.value)
    }
    println()
    println("The name for each rune:")
    for (rune in elderFutharkRunes) {
        print("$rune ")
    }
}
