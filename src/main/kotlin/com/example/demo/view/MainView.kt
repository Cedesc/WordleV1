package com.example.demo.view

import com.example.demo.style.Styles
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.paint.Color
import tornadofx.*

class MainView : View("WordleX3Z") {
    // TODO: add Tests? Is it possible or meaningful to have tests for this?

    override val root = vbox {

        // create word board
        gridpane {
            // add style class
            addClass(Styles.wordBoard)
            // align in the center
            alignment = Pos.CENTER
            // add fields
            for (row in 0 until 5) {
                row {
                    for (col in 0 until 5) {
                        stackpane {
                            rectangle(width = 50.0, height = 50.0) {
                                fill = Color.LIGHTGRAY
                                stroke = Color.BLACK
                                strokeWidth = 1.0
                            }
                            label("$col , $row") {
                                prefWidth = 50.0
                                prefHeight = 50.0
                                alignment = Pos.CENTER
                            }
                        }
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