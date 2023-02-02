package com.example.demo.model

/**
 * Representation of a word / row in the [WordBoard].
 * Contains as many instances of [LetterBox] as [WordBoard.resultWord] has letters.
 *
 * @constructor Create a new and empty [Word] with as many instances of [LetterBox] as [WordBoard.resultWord] has letters.
 * @param resultWordLength Length of [WordBoard.resultWord].
 */
class Word(resultWordLength: Int) {

    /**
     * Representation of the letters. Each letter is exactly one [LetterBox].
     */
    val letters: Array<LetterBox> = Array(resultWordLength) { _ -> LetterBox() }


    /**
     * @return True if the given word is the same as [WordBoard.resultWord], False otherwise.
     */
    fun checkWord(resultWord: String): Boolean {
        // raise error if the words have different length
        if (resultWord.length != letters.size) throw IllegalArgumentException("The length of the passed resultWord " +
                "and the number of saved letters must be the same.")

        // zip resultWordLetters and LetterBoxLetters
        val zippedLetters = resultWord.toCharArray().zip(letters)

        // for each letter, check if the letter is in the complete word and if the letters are the same
        for ((resultLetter, actualLetter) in zippedLetters) {
            actualLetter.checkIfLetterIsInWord(resultWord)
            actualLetter.compareLetter(resultLetter)
        }

        // return true if the complete word is correct
        return letters.all { it.state == 3 }
    }

    override fun toString(): String {
        return "Word(letters=${letters.contentToString()})"
    }

}