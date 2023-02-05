package com.example.demo.view.nodes

import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.scene.text.Font
import javafx.scene.text.FontWeight

class LetterBoxShape : StackPane() {

    /**
     * Color of the box. Initialized with 0 (black). Changing the state will automatically change the box color.
     *
     * The value can be one of the following:
     * - 0: black (not checked yet)
     * - 1: grey (wrong letter)
     * - 2: yellow (correct letter, wrong place)
     * - 3: green (correct letter, correct place)
     */
    var state: Int = 0
        set(value) {
            // state can only be between 0 and 3
            if (value in 0..3) {
                field = value

                rectangle.fill = when (value) {
                    0 -> Color.BLACK
                    1 -> Color.GRAY
                    2 -> Color.YELLOW
                    3 -> Color.GREEN
                    else -> rectangle.fill
                }
            }
        }

    private val rectangle = Rectangle(50.0, 50.0).apply {
        fill = Color.BLACK
        stroke = Color.LIGHTGRAY
        strokeWidth = 1.0
    }

    private val label = Label("Q").apply {
        textFill = Color.WHITE
        font = Font.font("Arial", FontWeight.BOLD, 14.0)
        prefWidth = 50.0
        prefHeight = 50.0
        alignment = Pos.CENTER
    }


    init {
        children.addAll(rectangle, label)
    }

}