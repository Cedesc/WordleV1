package com.example.demo.model

/**
 * Contains the [WordBoard] and [KeyBoard], providing a connection between them.
 *
 * @constructor Creates a new [Game] with a new [WordBoard] and [KeyBoard].
 * @param resultWord Solution word to the Wordle.
 * @param numberOfRows Total number of rows the user can fill.
 */
class Game(resultWord: String, numberOfRows: Int) {
    // TODO: write tests for constructor

    /**
     * The saved instance of [WordBoard].
     */
    private val wordBoard: WordBoard = WordBoard(resultWord, numberOfRows)

    /**
     * The saved instance of [KeyBoard].
     */
    private val keyBoard: KeyBoard = KeyBoard()


    override fun toString(): String {
        return "Game(wordBoard=$wordBoard, keyBoard=$keyBoard)"
    }

}