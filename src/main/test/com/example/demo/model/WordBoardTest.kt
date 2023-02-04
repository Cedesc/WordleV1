package com.example.demo.model

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

class WordBoardTest {

    @Test
    fun testCheckWord_validWord() {
        val wordBoard = WordBoard("word", 3)

        word_quickFill(wordBoard.rows[0], 'a', 'e', 'r', 'o')
        word_quickFill(wordBoard.rows[1], 'w', 'o', 'r', 'd')

        assertFalse(wordBoard.checkWord())

        assertTrue(wordBoard.checkWord())
    }

    @Test
    fun testCheckWord_maximumNumberOfRowsReached() {
        val wordBoard = WordBoard("say", 2)

        word_quickFill(wordBoard.rows[0], 'h', 'e', 'y')
        word_quickFill(wordBoard.rows[1], 'f', 'o', 'r')

        assertFalse(wordBoard.checkWord())

        assertFalse(wordBoard.checkWord())

        assertThrows<IndexOutOfBoundsException> { wordBoard.checkWord() }
    }

    @Test
    fun testToString() {
        val wordBoard = WordBoard("word", 1)

        val result = wordBoard.toString()

        assertEquals("WordBoard(resultWord='word', numberOfRows=1, currentRow=0, rows=[Word(wordLength=4)])", result)
    }


    /**
     * Fills the instances of [LetterBox] of a [Word] with the passed characters.
     */
    private fun word_quickFill(word: Word, vararg letters: Char): Unit {
        for (letterIndex in letters.indices) {
            word.letters[letterIndex].letter = letters[letterIndex]
        }
    }

}