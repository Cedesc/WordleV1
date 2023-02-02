package com.example.demo.model

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class LetterBoxTest {

    @Test
    fun testCheckIfLetterIsInWord_whenContains() {
        val letterBox = LetterBox()
        letterBox.letter = 'a'
        val result = letterBox.checkIfLetterIsInWord("abc")
        assertEquals(true, result)
        assertEquals(2, letterBox.state)
    }

    @Test
    fun testCheckIfLetterIsInWord_whenNotContains() {
        val letterBox = LetterBox()
        letterBox.letter = 'd'
        val result = letterBox.checkIfLetterIsInWord("abc")
        assertEquals(false, result)
        assertEquals(1, letterBox.state)
    }

    @Test
    fun testCompareLetter_whenEqual() {
        val letterBox = LetterBox()
        letterBox.letter = 'a'
        val result = letterBox.compareLetter('a')
        assertEquals(true, result)
        assertEquals(3, letterBox.state)
    }

    @Test
    fun testCompareLetter_whenNotEqual() {
        val letterBox = LetterBox()
        letterBox.letter = 'a'
        val result = letterBox.compareLetter('b')
        assertEquals(false, result)
        assertEquals(0, letterBox.state)
    }

    @Test
    fun testSetLetter_withValidValue() {
        val letterBox = LetterBox()
        letterBox.letter = 'a'
        assertEquals('a', letterBox.letter)
    }

    @Test
    fun testSetLetter_withInvalidValue() {
        val letterBox = LetterBox()
        letterBox.letter = '&'
        assertEquals(' ', letterBox.letter)
    }

    @Test
    fun testSetLetter_withBlank() {
        val letterBox = LetterBox()
        letterBox.letter = 'c'
        assertEquals('c', letterBox.letter)
        letterBox.letter = ' '
        assertEquals(' ', letterBox.letter)
    }

    @Test
    fun testSetState_withValidValue() {
        val letterBox = LetterBox()
        letterBox.state = 2
        assertEquals(2, letterBox.state)
    }

    @Test
    fun testSetState_withInvalidValue() {
        val letterBox = LetterBox()
        letterBox.state = 4
        assertEquals(0, letterBox.state)
        letterBox.state = -1
        assertEquals(0, letterBox.state)
    }
}