package com.example.demo.model

/**
 * Contains the letter rows as multiple instances of [Word].
 *
 * @constructor Create a new and empty [WordBoard].
 * @param resultWord Solution word to the Wordle.
 * @param numberOfRows Total number of rows the user can fill.
 */
class WordBoard(resultWord: String, numberOfRows: Int) {
    // TODO: write tests for constructor

    /**
     * Solution word to the Wordle.
     */
    private val resultWord: String = resultWord

    /**
     * Total number of rows the user can fill.
     */
    private val numberOfRows: Int = numberOfRows

    /**
     * Number of the actual row where the user can insert letters.
     */
    private val currentRow: Int = 0

    // TODO: write tests
    /**
     * Representation of the board rows. Each row is exactly one [Word].
     */
    private val rows: Array<Word> = Array(numberOfRows) { _ -> Word(resultWord.length) }


    /**
     *
     * @return True if the given word is the same as [WordBoard.resultWord], False otherwise.
     */
    private fun checkWord(): Boolean {
        // TODO: Not yet implemented.
        return false
    }

}