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
        println("Enter")
        // TODO: Not yet implemented.
    }

    /**
     * Called when the back key is pressed.
     */
    fun backPressed() {
        println("Back")
        // TODO: Not yet implemented.
    }

    /**
     * Called when a letter key is pressed. It sets the letter in the current row and
     * column of the word board.
     *
     * @param letter the letter that was pressed
     */
    fun letterKeyPressed(letter: Char) {
        println(letter)
        gameInstance.wordBoard.rows[currentRow].letters[currentColumn].letter = letter
        // TODO: Check if it is allowed to set the next letter AND go automatically to the next field.
    }

}