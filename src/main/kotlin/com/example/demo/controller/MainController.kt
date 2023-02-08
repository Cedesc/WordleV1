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
     * Current column in the word board that the player is on.
     */
    private var currentColumn: Int = 0

    /**
     * Current row in the word board that the player is on.
     */
    private val currentRow: Int
        get() = gameInstance.wordBoard.currentRow


    /**
     * Called when the enter key is pressed.
     */
    fun enterPressed() {
        // Check if the current row is full so that the complete word can be checked. If the word isn't full, no
        // the word can't be checked -> nothing happens.
        if (! gameInstance.wordBoard.rows[currentRow].isFull())
            return

        // Call checkWord
        gameInstance.wordBoard.checkWord()

        // set the column counter back to the start
        currentColumn = 0
    }

    /**
     * Called when the back key is pressed.
     */
    fun backPressed() {
        // Check if the current row isn't empty so that the last set letter can be deleted. If the word is empty, no
        // letter can be deleted -> nothing happens.
        if (gameInstance.wordBoard.rows[currentRow].isEmpty())
            return

        // decrement the column counter
        currentColumn -= 1

        // delete the last letter
        gameInstance.wordBoard.rows[currentRow].letterBoxes[currentColumn].letter = ' '
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

        // set the letter on the current position
        gameInstance.wordBoard.rows[currentRow].letterBoxes[currentColumn].letter = letter

        // increment the column counter
        currentColumn += 1
    }

}