package com.example.demo.model

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

class WordBoardTest {

    @Test
    fun testCheckWord_validWord() {
        val wordBoard = WordBoard("WORD", 3)

        word_quickFill(wordBoard.rows[0], 'A', 'E', 'R', 'O')
        word_quickFill(wordBoard.rows[1], 'W', 'O', 'R', 'D')

        assertFalse(wordBoard.checkWord())

        assertTrue(wordBoard.checkWord())
    }

    @Test
    fun testCheckWord_maximumNumberOfRowsReached() {
        val wordBoard = WordBoard("SAY", 2)

        word_quickFill(wordBoard.rows[0], 'H', 'E', 'Y')
        word_quickFill(wordBoard.rows[1], 'F', 'O', 'R')

        assertFalse(wordBoard.checkWord())

        assertFalse(wordBoard.checkWord())

        assertThrows<IndexOutOfBoundsException> { wordBoard.checkWord() }
    }

    @Test
    fun testToString() {
        val wordBoard = WordBoard("WORD", 1)

        val result = wordBoard.toString()

        assertEquals("WordBoard(resultWord='WORD', numberOfRows=1, currentRow=0, " +
                "rows=[Word(letters=[LetterBox(letter= , state=0), LetterBox(letter= , state=0), " +
                "LetterBox(letter= , state=0), LetterBox(letter= , state=0)])])", result)
    }


    /**
     * Fills the instances of [LetterBox] of a [Word] with the passed characters.
     */
    private fun word_quickFill(word: Word, vararg letters: Char): Unit {
        for (letterIndex in letters.indices) {
            word.letterBoxes[letterIndex].letter = letters[letterIndex]
        }
    }

}