package com.example.demo.model

/**
 * Representation of a letter in the [WordBoard].
 */
class LetterBox {
    // TODO: write tests for constructor

    /**
     * Shown letter. Initialized with null.
     */
    private var letter: Char? = null

    /**
     * Color of the box.
     *
     * - 0: black (not checked yet)
     * - 1: grey (wrong letter)
     * - 2: yellow (correct letter, wrong place)
     * - 3: green (correct letter, correct place)
     */
    private var state: Int = 0


    /**
     * @return True if resultWord contains [LetterBox.letter], False otherwise.
     */
    private fun checkIfLetterIsInWord(resultWord: String): Boolean {
        // TODO: Not yet implemented.
        return false
    }

    /**
     * @return True if the given letter is the same as [LetterBox.letter], False otherwise.
     */
    private fun compareLetter(letter: Char): Boolean {
        // TODO: Not yet implemented.
        return false
    }

}