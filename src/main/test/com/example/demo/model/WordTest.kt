package com.example.demo.model

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

class WordTest {

    @Test
    fun testCheckWord_sameWord() {
        val word = Word(4)
        word.letters[0].letter = 'T'
        word.letters[1].letter = 'E'
        word.letters[2].letter = 'S'
        word.letters[3].letter = 'T'
        assertTrue(word.checkWord("TEST"))
        // all LetterBoxes should be green
        assertTrue(word.letters[0].state == 3)
        assertTrue(word.letters[1].state == 3)
        assertTrue(word.letters[2].state == 3)
        assertTrue(word.letters[3].state == 3)
    }

    @Test
    fun testCheckWord_differentWord() {
        val word = Word(5)
        word.letters[0].letter = 'S'
        word.letters[1].letter = 'A'
        word.letters[2].letter = 'I'
        word.letters[3].letter = 'L'
        word.letters[4].letter = 'S'
        assertFalse(word.checkWord("TASTY"))
        assertTrue(word.letters[0].state == 2)
        assertTrue(word.letters[1].state == 3)
        assertTrue(word.letters[2].state == 1)
        assertTrue(word.letters[3].state == 1)
        assertTrue(word.letters[4].state == 2)
    }

    @Test
    fun testCheckWord_differentWordLength() {
        val word = Word(8)
        assertThrows<IllegalArgumentException> { word.checkWord("SHORTER") }
        assertThrows<IllegalArgumentException> { word.checkWord("MUCH LONGER") }
    }

    @Test
    fun testToString() {
        val word = Word(3)
        assertEquals("Word(letters=[LetterBox(letter= , state=0), " +
                "LetterBox(letter= , state=0), LetterBox(letter= , state=0)])", word.toString())
        word.letters[0].letter = 'H'
        word.letters[0].state = 3
        word.letters[1].letter = 'E'
        word.letters[1].state = 2
        word.letters[2].letter = 'Y'
        word.letters[2].state = 1
        assertEquals("Word(letters=[LetterBox(letter=H, state=3), " +
                "LetterBox(letter=E, state=2), LetterBox(letter=Y, state=1)])", word.toString())
    }
}