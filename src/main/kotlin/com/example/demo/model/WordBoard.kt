package com.example.demo.model

/**
 * Contains the letter rows as multiple instances of [Word].
 *
 * @constructor Creates a new and empty [WordBoard].
 * @param resultWord Solution word to the Wordle.
 * @param numberOfRows Total number of rows the user can fill.
 */
class WordBoard(resultWord: String, numberOfRows: Int) {

    /**
     * Solution word to the Wordle.
     */
    private val resultWord: String = resultWord

    /**
     * Maximum number of rows that the user is able to fill.
     */
    private val numberOfRows: Int = numberOfRows

    /**
     * Number of the actual row where the user can insert letters.
     */
    private var currentRow: Int = 0

    /**
     * Representation of the board rows. Each row is exactly one instance of [Word].
     */
    val rows: Array<Word> = Array(numberOfRows) { _ -> Word(resultWord.length) }


    /**
     * Checks if the passed word is the same as [resultWord].
     *
     * @return True if the passed word is the same as [resultWord], False otherwise.
     * @throws IndexOutOfBoundsException If the maximum size of rows has already been reached.
     */
    fun checkWord(): Boolean {
        // increment current row and throw an error if the maximum size of rows has been reached already
        if (! incrementCurrentRow()) throw IndexOutOfBoundsException("The maximum size of rows has been reached " +
                "already.")

        // Call checkWord of the actual row (instance of Word). Since currentRow has already been increased, the index
        // of the actual row is (currentRow - 1).
        return rows[currentRow - 1].checkWord(resultWord)
    }

    /**
     * Increments the [currentRow] by 1 if the new value of [currentRow] is less than [numberOfRows] (maximum of rows).
     *
     * @return True if [currentRow] has been incremented and is less than [numberOfRows] (maximum of rows),
     * False otherwise.
     */
    private fun incrementCurrentRow(): Boolean {
       if (currentRow + 1 <= numberOfRows) {
           currentRow++
           return true
       }
       return false
    }

    /**
     * Returns a string representation of the [WordBoard] object, including the string representation of its
     * [rows] property ([Word]).
     *
     * @return A string representation of the [WordBoard] object.
     */
    override fun toString(): String {
        return "WordBoard(resultWord='$resultWord', numberOfRows=$numberOfRows, currentRow=$currentRow, " +
                "rows=${rows.contentToString()})"
    }

}