package com.example.demo.model

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class LetterBoxTest {

    @Test
    fun testCheckIfLetterIsInWord_whenContains() {
        val letterBox = LetterBox()
        letterBox.letter = 'A'
        val result = letterBox.checkIfLetterIsInWord("ABC")
        assertEquals(true, result)
        assertEquals(2, letterBox.state)
    }

    @Test
    fun testCheckIfLetterIsInWord_whenNotContains() {
        val letterBox = LetterBox()
        letterBox.letter = 'D'
        val result = letterBox.checkIfLetterIsInWord("ABC")
        assertEquals(false, result)
        assertEquals(1, letterBox.state)
    }


    @Test
    fun testCompareLetter_whenEqual() {
        val letterBox = LetterBox()
        letterBox.letter = 'A'
        val result = letterBox.compareLetter('A')
        assertEquals(true, result)
        assertEquals(3, letterBox.state)
    }

    @Test
    fun testCompareLetter_whenNotEqual() {
        val letterBox = LetterBox()
        letterBox.letter = 'A'
        val result = letterBox.compareLetter('B')
        assertEquals(false, result)
        assertEquals(0, letterBox.state)
    }


    @Test
    fun testSetLetter_withValidValue() {
        val letterBox = LetterBox()
        letterBox.letter = 'A'
        assertEquals('A', letterBox.letter)
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
        letterBox.letter = 'C'
        assertEquals('C', letterBox.letter)
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


    @Test
    fun testToString_black() {
        val lb = LetterBox()
        lb.letter = 'A'
        assertEquals("LetterBox(letter=A, state=0)", lb.toString())
    }

    @Test
    fun testToString_grey() {
        val lb = LetterBox()
        lb.state = 1
        assertEquals("LetterBox(letter= , state=1)", lb.toString())
    }

    @Test
    fun testToString_yellow() {
        val lb = LetterBox()
        lb.letter = 'C'
        lb.state = 2
        assertEquals("LetterBox(letter=C, state=2)", lb.toString())
    }

    @Test
    fun testToString_green() {
        val lb = LetterBox()
        lb.letter = 'D'
        lb.state = 3
        assertEquals("LetterBox(letter=D, state=3)", lb.toString())
    }

}