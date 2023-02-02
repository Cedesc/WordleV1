package com.example.demo.model

/**
 * Representation of a letter in the [WordBoard].
 */
class LetterBox {

    /**
     * Shown letter. Initialized with null.
     */
    var letter: Char = ' '
        set(value) {
            if ("abcdefghijklmnopqrstuvwxyz ".contains(value))
                field = value
        }

    /**
     * Color of the box.
     *
     * - 0: black (not checked yet)
     * - 1: grey (wrong letter)
     * - 2: yellow (correct letter, wrong place)
     * - 3: green (correct letter, correct place)
     */
    var state: Int = 0
        set(value) {
            field = maxOf(0, minOf(value, 3))
        }


    /**
     * @return True if resultWord contains [LetterBox.letter], False otherwise.
     */
    fun checkIfLetterIsInWord(resultWord: String): Boolean {
        // check
        val contains = resultWord.contains(letter)

        // update state
        state = if (contains) 2 else 1

        return contains
    }

    /**
     * @return True if the given letter is the same as [LetterBox.letter], False otherwise.
     */
    fun compareLetter(inputLetter: Char): Boolean {
        // compare
        val equal = inputLetter == letter

        // update state
        if (equal) state = 3

        return equal
    }

    override fun toString(): String {
        return "LetterBox(letter=$letter, state=$state)"
    }

}