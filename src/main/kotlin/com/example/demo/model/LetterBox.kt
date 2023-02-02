package com.example.demo.model

/**
 * Representation of a letter in the [WordBoard].
 *
 * @property letter The shown letter in the box.
 * @property state The color of the box.
 */
class LetterBox {

    /**
     * Shown letter. Initialized with a space character.
     */
    var letter: Char = ' '
        set(value) {
            if ("abcdefghijklmnopqrstuvwxyz ".contains(value))
                field = value
        }

    /**
     * Color of the box. Initialized with 0 (black).
     *
     * The value can be one of the following:
     * - 0: black (not checked yet)
     * - 1: grey (wrong letter)
     * - 2: yellow (correct letter, wrong place)
     * - 3: green (correct letter, correct place)
     */
    var state: Int = 0
        set(value) {
            if (value in 0..3)
                field = value
        }


    /**
     * Check if the given result word contains the [letter].
     *
     * If the word contains the letter, the [state] is set to 2 (yellow).
     * If the word does not contain the letter, the [state] is set to 1 (grey).
     *
     * @param resultWord the word to check for the letter.
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
     * Compare the given input letter to the [letter].
     *
     * If the input letter is the same as the letter, the [state] is set to 3 (green).
     *
     * @param inputLetter the letter to compare to the [letter].
     * @return True if the given letter is the same as [LetterBox.letter], False otherwise.
     */
    fun compareLetter(inputLetter: Char): Boolean {
        // compare
        val equal = inputLetter == letter

        // update state
        if (equal) state = 3

        return equal
    }

    /**
     * @return A string representation of the [LetterBox] in the format "LetterBox(letter=X, state=Y)",
     * where X is the letter and Y is the state.
     */
    override fun toString(): String {
        return "LetterBox(letter=$letter, state=$state)"
    }

}