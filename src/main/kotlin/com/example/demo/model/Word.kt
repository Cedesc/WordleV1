package com.example.demo.model

/**
 * Representation of a word / row in the [WordBoard].
 * Contains as many instances of [LetterBox] as [WordBoard.resultWord] has letters.
 *
 * @constructor Create a new and empty [Word] with as many instances of [LetterBox] as [WordBoard.resultWord] has letters.
 * @param resultWordLength Length of [WordBoard.resultWord].
 */
class Word(resultWordLength: Int) {
    // TODO: write tests for constructor

    // TODO: write tests
    /**
     * Representation of the letters. Each letter is exactly one [LetterBox].
     */
    private val letters: Array<LetterBox> = Array(resultWordLength) { _ -> LetterBox() }


    /**
     * @return True if the given word is the same as [WordBoard.resultWord], False otherwise.
     */
    private fun checkWord(resultWord: String): Boolean {
        // TODO: Not yet implemented.
        return false
    }

}