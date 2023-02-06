package com.example.demo.model

/**
 * Representation of a word / row in the [WordBoard].
 * Contains as many instances of [LetterBox] as [WordBoard.resultWord] has letters.
 *
 * @constructor Creates a new and empty [Word] with as many instances of [LetterBox] as [WordBoard.resultWord] has letters.
 * @param resultWordLength Length of [WordBoard.resultWord].
 */
class Word(resultWordLength: Int) {

    /**
     * Represents the individual letters in the word.
     * Each letter is represented by exactly one instance of [LetterBox].
     */
    val letterBoxes: Array<LetterBox> = Array(resultWordLength) { _ -> LetterBox() }


    /**
     * Determines if the passed `resultWord` is equal to [WordBoard.resultWord].
     *
     * Calls [LetterBox.checkIfLetterIsInWord] and [LetterBox.compareLetter], which change the states of the individual letters in
     * [letterBoxes] are change.
     *
     * @return True if the passed word is equal to [WordBoard.resultWord], False otherwise.
     * @throws IllegalArgumentException If the passed resultWord and [letterBoxes] have different length.
     */
    fun checkWord(resultWord: String): Boolean {
        // throw an error if the words have different length
        if (resultWord.length != letterBoxes.size) throw IllegalArgumentException("The length of the passed resultWord " +
                "and the number of saved letters must be the same.")

        // zip resultWordLetters and LetterBoxLetters
        val zippedLetters = resultWord.toCharArray().zip(letterBoxes)

        // for each letter, check if the letter is in the complete word and if the letters are the same
        for ((resultLetter, actualLetter) in zippedLetters) {
            actualLetter.checkIfLetterIsInWord(resultWord)
            actualLetter.compareLetter(resultLetter)
        }

        // return true if the complete word is correct
        return letterBoxes.all { it.state == 3 }
    }

    /**
     * @return A string representation of the [Word] object, including the string representation of its [letterBoxes]
     * property.
     */
    override fun toString(): String {
        return "Word(letters=${letterBoxes.contentToString()})"
    }

}