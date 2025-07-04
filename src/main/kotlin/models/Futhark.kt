package org.example.models

class Futhark {
    val elderFutharkRunes = mapOf(
        "Fehu" to '\u16A0',
        "Uruz" to '\u16A2',
        "Thurisaz" to '\u16A6',
        "Ansuz" to '\u16A8',
        "Raido" to '\u16B1',
        "Kauna" to '\u16B2'
    )

    fun printFuthark() {
        for (r in elderFutharkRunes) {
            println(r)
        }
    }
}