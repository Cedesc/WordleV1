package com.example.demo.controller

import com.example.demo.model.*
import tornadofx.*

/**
 * MainController is a [Controller] for managing the main logic of the application.
 */
class MainController : Controller() {

    /**
     * Word that the player needs to guess.
     */
    val resultWord: String = "WORD"

    /**
     * Number of rows in the game's word board.
     */
    val numberOfRows: Int = 5

    /**
     * Instance of [Game] class containing [WordBoard] and [KeyBoard].
     */
    val gameInstance: Game = Game(resultWord, numberOfRows)


    /**
     * Current row in the word board that the player is on.
     */
    private val currentRow: Int
        get() = gameInstance.wordBoard.currentRow

    /**
     * Current column in the word board that the player is on.
     */
    private var currentColumn: Int
        get() = gameInstance.wordBoard.rows[currentRow].currentColumn
        set(value) {
            gameInstance.wordBoard.rows[currentRow].currentColumn = value
        }


    /**
     * Called when the enter key is pressed.
     */
    fun enterPressed() {
        // Check if the current row is full so that the complete word can be checked. If the word isn't full, no
        // the word can't be checked -> nothing happens.
        if (! gameInstance.wordBoard.rows[currentRow].isFull())
            return

        // Call checkWord: updates the status of each letter and increments the currentRow.
        gameInstance.wordBoard.checkWord()
    }

    /**
     * Called when the back key is pressed.
     */
    fun backPressed() {
        // Check if the current row isn't empty so that the last set letter can be deleted. If the word is empty, no
        // letter can be deleted -> nothing happens.
        if (gameInstance.wordBoard.rows[currentRow].isEmpty())
            return

        // Call deleteLastLetter: decrements the currentColumn and deletes the last letter.
        gameInstance.wordBoard.rows[currentRow].deleteLastLetter()
    }

    /**
     * Called when a letter key is pressed. It sets the letter in the current row and
     * column of the word board.
     *
     * @param letter the letter that was pressed
     */
    fun letterKeyPressed(letter: Char) {
        // Check if the current row isn't full so that another letter can be set. If the word is full, no additional
        // letter can be added -> nothing happens.
        if (gameInstance.wordBoard.rows[currentRow].isFull())
            return

        // Call setNextLetter: sets the next letter and increments the currentColumn.
        gameInstance.wordBoard.rows[currentRow].setNextLetter(letter)
    }

}