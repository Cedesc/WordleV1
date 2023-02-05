package com.example.demo.view

import com.example.demo.controller.MainController
import com.example.demo.style.Styles
import com.example.demo.view.nodes.LetterBoxShape
import com.example.demo.view.viewmodel.WordBoardModel
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.geometry.Pos
import tornadofx.*

class MainView : View("WordleX3Z") {
    // TODO: add Tests? Is it possible or meaningful to have tests for this?

    // inject controller
    private val mainController: MainController by inject()

    // set number of rows and number of columns
    private val numberOfRows: Int = mainController.numberOfRows
    private val numberOfColumns: Int = mainController.resultWord.length


    private val wordBoardModel: WordBoardModel by inject()



    override val root = vbox {

        // create word board
        gridpane {
            // add style class
            addClass(Styles.wordBoard)
            // align in the center
            alignment = Pos.CENTER
            // add fields
            for (row in 0 until numberOfRows) {
                row {
                    for (col in 0 until numberOfColumns) {

                        add(LetterBoxShape())

                    }
                }
            }
        }


        // horizontal separator line
        separator(Orientation.HORIZONTAL) {
            padding = Insets(15.0, 10.0, 15.0, 10.0)
        }


        // TODO: arrange rows in a way that the keyboard has a symmetric shape
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
                    action { println(letter) } }
                }
            }

            // second row of the keyboard
            hbox {
                alignment = Pos.CENTER
                // create second row of letter keys
                for (letter in "ASDFGHJKL") { button(letter.toString()) {
                    addClass(Styles.keyboardButton)
                    action { println(letter) } }
                }
            }

            // third row of the keyboard
            hbox {
                alignment = Pos.CENTER
                // create enter button
                button("ENTER") {
                    addClass(Styles.keyboardButton)
                    action { println("Enter") }
                }

                // create third row of letter keys
                for (letter in "YXCVBNM") { button(letter.toString()) {
                    addClass(Styles.keyboardButton)
                    action { println(letter) } }
                }

                // create back button
                button("BACK") {
                    action { println("Back") }
                    addClass(Styles.keyboardButton)
                }
            }


        }

    }

}