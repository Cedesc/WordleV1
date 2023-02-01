package com.example.demo.model

/**
 * Contains the [WordBoard] and [KeyBoard], providing a connection between them.
 *
 * @property resultWord The solution to the Wordle.
 *
 * @constructor Creates a new [Game] with a new [WordBoard] and [KeyBoard].
 * @param resultWord The solution to the Wordle.
 */
class Game(private val resultWord: String) {
}