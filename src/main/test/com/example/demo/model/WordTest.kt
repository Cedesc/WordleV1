package com.example.demo.model

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

class WordTest {

    @Test
    fun testCheckWord_sameWord() {
        val word = Word(4)
        word.letters[0].letter = 't'
        word.letters[1].letter = 'e'
        word.letters[2].letter = 's'
        word.letters[3].letter = 't'
        assertTrue(word.checkWord("test"))
    }

    @Test
    fun testCheckWord_otherWord() {
        val word = Word(3)
        word.letters[0].letter = 's'
        word.letters[1].letter = 'a'
        word.letters[2].letter = 'y'
        assertTrue(word.checkWord("not"))
    }

    @Test
    fun testCheckWord_differentWordLength() {
        val word = Word(8)
        assertThrows<IllegalArgumentException> { word.checkWord("shorter") }
        assertThrows<IllegalArgumentException> { word.checkWord("much longer") }
    }

    @Test
    fun testToString() {
        val word = Word(3)
        assertEquals("Word(letters=[LetterBox(letter= , state=0), " +
                "LetterBox(letter= , state=0), LetterBox(letter= , state=0)])", word.toString())
        word.letters[0].letter = 'h'
        word.letters[0].state = 3
        word.letters[1].letter = 'e'
        word.letters[1].state = 2
        word.letters[2].letter = 'y'
        word.letters[2].state = 1
        assertEquals("Word(letters=[LetterBox(letter=h, state=3), " +
                "LetterBox(letter=e, state=2), LetterBox(letter=y, state=1)])", word.toString())
    }
}