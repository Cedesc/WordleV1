package com.example.demo.model

/**
 * Letter key of the [KeyBoard].
 */
class KeyBoardLetter(letter: Char) {
    // TODO: write tests for constructor

    /**
     * Letter of the key.
     */
    private val letter: Char = letter

    /**
     * Color of the key.
     *
     * - 0: grey (not checked yet)
     * - 1: black (letter isn't in the solution word)
     * - 2: yellow (letter is in the solution word, but at the wrong place)
     * - 3: green (letter is in the solution word, at the correct place)
     */
    private val state: Int = 0

}