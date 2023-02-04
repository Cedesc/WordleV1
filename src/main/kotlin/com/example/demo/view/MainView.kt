package com.example.demo.view

import com.example.demo.style.Styles
import javafx.geometry.Insets
import javafx.geometry.Orientation
import tornadofx.*

class MainView : View("WordleX3Z") {
    // TODO: add Tests? Is it possible or meaningful to have tests for this?

    override val root = vbox {

        label("Hello World") {
            addClass(Styles.heading)
        }

        // horizontal line
        separator(Orientation.HORIZONTAL) {
            padding = Insets(5.0, 10.0, 25.0, 10.0)
        }


        // TODO: arrange rows in a way that the keyboard has a symmetric shape
        // create keyboard
        vbox {

            // first row of the keyboard
            hbox {
                // create first row of letter keys
                for (letter in "QWERTZUIOP") { button(letter.toString()) {
                    addClass(Styles.keyboardButton)
                    action { println(letter) } }
                }
            }

            // second row of the keyboard
            hbox {
                // create second row of letter keys
                for (letter in "ASDFGHJKL") { button(letter.toString()) {
                    addClass(Styles.keyboardButton)
                    action { println(letter) } }
                }
            }

            // third row of the keyboard
            hbox {
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