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
     * Number of the actual column where the next letter is placed. The minimum is 0, the maximum is the number of
     * letters ( = letterBoxes.size + 1). If the currentColumn is at its maximum means that the word is full.
     */
    var currentColumn: Int = 0 // TODO: write tests
        set(value) {
            if (value < 0)
                throw ArithmeticException("The column index can't be less than zero.")
            if (value > letterBoxes.size)
                throw ArithmeticException("The column index can't be higher than letterBoxes.size + 1.")
            field = value
        }


    /**
     * Determines if the passed `resultWord` is equal to [WordBoard.resultWord].
     *
     * Calls [LetterBox.checkIfLetterIsInWord] and [LetterBox.compareLetter], which change the states of the individual letters in
     * [letterBoxes] are change.
     *
     * Sets the [currentColumn] to zero.
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

        // set currentColumn back to zero
        currentColumn = 0 // TODO: write tests for this line

        // return true if the complete word is correct
        return letterBoxes.all { it.state == 3 }
    }

    /**
     * Decrements [currentColumn] and deletes the last letter.
     */
    fun deleteLastLetter() { // TODO: write tests
        // decrement the column counter
        currentColumn -= 1

        // delete the last letter
        letterBoxes[currentColumn].letter = ' '
    }

    /**
     * Sets the given letter at the current position ([currentColumn]) and increments [currentColumn].
     *
     * @param letter The input letter for the [LetterBox].
     */
    fun setNextLetter(letter: Char) { // TODO: write tests
        // set the letter at the current postion
        letterBoxes[currentColumn].letter = letter

        // increment the column counter
        currentColumn += 1
    }

    /**
     * @return True if all letters are set (the word is full), False otherwise.
     */
    fun isFull(): Boolean {
        return letterBoxes.last().letter != ' '
    }

    /**
     * @return True if no letter is set (the word is empty), False otherwise.
     */
    fun isEmpty(): Boolean {
        return letterBoxes.first().letter == ' '
    }

    /**
     * @return A string representation of the [Word] object, including the string representation of its [letterBoxes]
     * property.
     */
    override fun toString(): String {
        return "Word(letters=${letterBoxes.contentToString()})"
    }

}