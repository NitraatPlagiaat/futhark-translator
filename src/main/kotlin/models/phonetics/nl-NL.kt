package models.phonetics

var graphemes = mapOf(
    "y" to ::getPhoneticForY
)

fun convertPhoneticsNL(sentence: String): String {
    var phoneticSentence = ""
    for (letter in sentence) {
        var tempLetter: Char = letter
        if (tempLetter == ' ') {
            phoneticSentence += ' '
            continue
        }
        phoneticSentence += tempLetter
    }
    return phoneticSentence
}

fun getPhoneticForY() {

}