package com.example.demo.view

import com.example.demo.controller.MainController
import com.example.demo.model.LetterBox
import com.example.demo.style.Styles
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.geometry.Pos
import tornadofx.*

/**
 * MainView is a [View] in TornadoFX that displays a game board for the Wordle game.
 *
 * The MainView has a title of "WordleX3Z" and has three main components:
 *  1. A game board, which is a [gridpane] containing letter boxes. The letter boxes are created with the
 *  [LetterBoxFragment] class and are populated with the letters from the game board in the mainController.
 *  2. A horizontal separator line, which separates the game board from the keyboard.
 *  3. A keyboard, which is a [vbox] containing instances of [hbox] containing letter keys and special keys
 *  (ENTER, BACK). The keys are created with the [button] function and have actions associated with them that
 *  call methods in the mainController.
 *
 * @property mainController is a controller for the MainView. It is injected through TornadoFX's dependency injection.
 * @property numberOfRows is the number of rows in the game board. It is obtained from the mainController.
 * @property numberOfColumns is the number of columns in the game board. It is obtained from the length of the result
 * word in the mainController.
 */
class MainView : View("WordleX3Z") {
    // TODO: add Tests? Is it possible or meaningful to have tests for this?

    // inject controller
    private val mainController: MainController by inject()

    // set number of rows and number of columns
    private val numberOfRows: Int = mainController.numberOfRows
    private val numberOfColumns: Int = mainController.resultWord.length


    override val root = vbox {

        // create word board
        gridpane {
            // add style class
            addClass(Styles.wordBoard)
            // align in the center
            alignment = Pos.CENTER
            // add fields (LetterBoxes)
            for (row in 0 until numberOfRows) {
                row {
                    for (col in 0 until numberOfColumns) {
                        val letter: LetterBox = mainController.gameInstance.wordBoard.rows[row].letterBoxes[col]
                        add<LetterBoxFragment>(LetterBoxFragment::letterBox to letter)
                    }
                }
            }
        }


        // horizontal separator line
        separator(Orientation.HORIZONTAL) {
            padding = Insets(15.0, 10.0, 15.0, 10.0)
        }


        // create keyboard
        vbox {
            // add style class
            addClass(Styles.keyBoard)

            // first row of the keyboard
            hbox {
                alignment = Pos.CENTER
                // create first row of letter keys
                for (letter in "QWERTZUIOP") { button(letter.toString()) {
                    addClass(Styles.keyboardButton)
                    action { mainController.letterKeyPressed(letter) } }
                }
            }

            // second row of the keyboard
            hbox {
                alignment = Pos.CENTER
                // create second row of letter keys
                for (letter in "ASDFGHJKL") { button(letter.toString()) {
                    addClass(Styles.keyboardButton)
                    action { mainController.letterKeyPressed(letter) } }
                }
            }

            // third row of the keyboard
            hbox {
                alignment = Pos.CENTER
                // create enter button
                button("ENTER") {
                    addClass(Styles.keyboardButton)
                    action { mainController.enterPressed() }
                }

                // create third row of letter keys
                for (letter in "YXCVBNM") { button(letter.toString()) {
                    addClass(Styles.keyboardButton)
                    action { mainController.letterKeyPressed(letter) } }
                }

                // create back button
                button("BACK") {
                    addClass(Styles.keyboardButton)
                    action { mainController.backPressed() }
                }
            }


        }

    }

}