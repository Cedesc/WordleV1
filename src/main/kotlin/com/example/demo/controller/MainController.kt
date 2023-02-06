package com.example.demo.controller

import com.example.demo.model.Game
import tornadofx.*

class MainController : Controller() {

    val resultWord: String = "WORD"

    val numberOfRows: Int = 5

    val gameInstance: Game = Game(resultWord, numberOfRows)


    private var currentColumn: Int = 0

    private val currentRow: Int
        get() = gameInstance.wordBoard.currentRow


    fun enterPressed() {
        println("Enter")
        // TODO: Not yet implemented.
    }

    fun backPressed() {
        println("Back")
        // TODO: Not yet implemented.
    }

    fun letterKeyPressed(letter: Char) {
        println(letter)
        gameInstance.wordBoard.rows[currentRow].letters[currentColumn].letter = letter
        // TODO: Check if it is allowed to set the next letter AND go automatically to the next field.
    }

}