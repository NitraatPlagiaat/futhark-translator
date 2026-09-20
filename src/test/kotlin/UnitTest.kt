import controllers.input
import controllers.skipLetter
import org.example.models.mapping.getCorrespondingRune
import org.example.models.mapping.getRune
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertNull

class UnitTest {
    @Test
    fun `test input for correct output`() {
        val phrase = "kale koppen met een muis"

        val result = input(phrase)

        assertEquals("ᚲᚨᛚᛖ ᚲᛟᛈᛈᛖᚾ ᛗᛖᛏ ᛖᚾ ᛗᚢᛁᛊ", result)
    }

    @Test
    fun `test removal double vowel`() {
        val phrase1 = "een"
        val phrase2 = "aan"

        val result1 = input(phrase1)
        val result2 = input(phrase2)

        assertEquals("ᛖᚾ", result1)
        assertEquals("ᚨᚾ", result2)
    }

    @Test
    fun `test get a single rune by name`() {
        val runeName1 = "Algiz"
        val runeName2 = "Sowilo"
        assertEquals('ᛉ', getRune(runeName1))
        assertEquals('ᛊ', getRune(runeName2))
    }

    @Test
    fun `test get the corresponding rune`() {
        val word1 = "depending"
        val word2 = "theme song"
        assertEquals('ᛜ', getCorrespondingRune(word1, 7))
        skipLetter = false
        assertEquals('ᚦ', getCorrespondingRune(word2, 0))
        skipLetter = false
        assertEquals('ᛈ', getCorrespondingRune(word1, 2))
        assertNull(getCorrespondingRune(word2, 5))
    }
}