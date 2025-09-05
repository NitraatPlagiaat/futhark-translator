package models.phonetics

fun convertPhonetics(sentence: String): String {
    var phoneticSentence = ""
    for (letter in sentence) {
        var tempLetter: Char = letter
        if (tempLetter == ' ') {
            phoneticSentence += ' '
            continue
        }
        phoneticSentence += tempLetter
    }
    return sentence
}