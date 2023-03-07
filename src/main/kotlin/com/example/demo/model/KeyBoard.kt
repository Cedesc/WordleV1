package com.example.demo.model

/**
 * Representation of the keyboard.
 */
class KeyBoard {

    /**
     * All letter keys of the keyboard.
     */
    private val letterKeys: Array<KeyBoardLetter>

    // TODO: write tests
    init {
        val alphabet: Array<Char> = Array(26) { i -> "qwertzuiopasdfghjklyxcvbnm"[i] }
        letterKeys = Array(26) { i -> KeyBoardLetter(alphabet[i]) }
    }


    /**
     * Executed if a letter key is pressed.
     */
    private fun letterKeyPressed() {
        // TODO: Not yet implemented.
    }

    /**
     * Executed if the enter key is pressed.
     */
    private fun enterPressed() {
        // TODO: Not yet implemented.
    }

    /**
     * Executed if the erase key is pressed.
     */
    private fun erasePressed() {
        // TODO: Not yet implemented.
    }

    override fun toString(): String {
        return "KeyBoard(letterKeys=${letterKeys.contentToString()})"
    }

}