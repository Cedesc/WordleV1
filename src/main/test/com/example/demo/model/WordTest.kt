package com.example.demo.model

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

class WordTest {

    @Test
    fun testCheckWord_sameWord() {
        val word = Word(4)
        word.letterBoxes[0].letter = 'T'
        word.letterBoxes[1].letter = 'E'
        word.letterBoxes[2].letter = 'S'
        word.letterBoxes[3].letter = 'T'
        assertTrue(word.checkWord("TEST"))
        // all LetterBoxes should be green
        assertTrue(word.letterBoxes[0].state == 3)
        assertTrue(word.letterBoxes[1].state == 3)
        assertTrue(word.letterBoxes[2].state == 3)
        assertTrue(word.letterBoxes[3].state == 3)
    }

    @Test
    fun testCheckWord_differentWord() {
        val word = Word(5)
        word.letterBoxes[0].letter = 'S'
        word.letterBoxes[1].letter = 'A'
        word.letterBoxes[2].letter = 'I'
        word.letterBoxes[3].letter = 'L'
        word.letterBoxes[4].letter = 'S'
        assertFalse(word.checkWord("TASTY"))
        assertTrue(word.letterBoxes[0].state == 2)
        assertTrue(word.letterBoxes[1].state == 3)
        assertTrue(word.letterBoxes[2].state == 1)
        assertTrue(word.letterBoxes[3].state == 1)
        assertTrue(word.letterBoxes[4].state == 2)
    }

    @Test
    fun testCheckWord_differentWordLength() {
        val word = Word(8)
        assertThrows<IllegalArgumentException> { word.checkWord("SHORTER") }
        assertThrows<IllegalArgumentException> { word.checkWord("MUCH LONGER") }
    }

    @Test
    fun testIsFull() {
        val word = Word(3)
        assertFalse(word.isFull())
        word.letterBoxes[0].letter = 'S'
        assertFalse(word.isFull())
        word.letterBoxes[1].letter = 'A'
        assertFalse(word.isFull())
        word.letterBoxes[2].letter = 'Y'
        assertTrue(word.isFull())
    }

    @Test
    fun testIsEmpty() {
        val word = Word(3)
        assertTrue(word.isEmpty())
        word.letterBoxes[0].letter = 'W'
        assertFalse(word.isEmpty())
        word.letterBoxes[1].letter = 'O'
        assertFalse(word.isEmpty())
        word.letterBoxes[2].letter = 'O'
        assertFalse(word.isEmpty())
    }

    @Test
    fun testToString() {
        val word = Word(3)
        assertEquals("Word(letters=[LetterBox(letter= , state=0), " +
                "LetterBox(letter= , state=0), LetterBox(letter= , state=0)])", word.toString())
        word.letterBoxes[0].letter = 'H'
        word.letterBoxes[0].state = 3
        word.letterBoxes[1].letter = 'E'
        word.letterBoxes[1].state = 2
        word.letterBoxes[2].letter = 'Y'
        word.letterBoxes[2].state = 1
        assertEquals("Word(letters=[LetterBox(letter=H, state=3), " +
                "LetterBox(letter=E, state=2), LetterBox(letter=Y, state=1)])", word.toString())
    }
}