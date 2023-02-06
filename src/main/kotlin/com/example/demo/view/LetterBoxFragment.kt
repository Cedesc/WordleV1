package com.example.demo.view

import com.example.demo.model.LetterBox
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*

/**
 * LetterBoxFragment is a [Fragment] that displays a [LetterBox].
 */
class LetterBoxFragment : Fragment() {
    /**
     * letterBox is the [LetterBox] that will be displayed by this fragment.
     */
    val letterBox: LetterBox by param()

    /**
     * letterProperty is a [SimpleStringProperty] that holds the current letter of the letter box.
     * It is bound to the letterProperty of the letterBox.
     */
    private val letterProperty = SimpleStringProperty(letterBox.letter.toString())
    /**
     * stateProperty is a [SimpleIntegerProperty] that holds the current state of the letter box.
     * It is bound to the stateProperty of the letterBox.
     */
    private val stateProperty = SimpleIntegerProperty(letterBox.state)

    /**
     * Initialize the letterProperty and stateProperty to be bound to the corresponding properties of the letterBox.
     */
    init {
        letterProperty.bind(letterBox.letterProperty)
        stateProperty.bind(letterBox.stateProperty)
    }


    /**
     * The root of the fragment.
     * A StackPane that contains a rectangle and a label.
     * The rectangle represents the background of the letter box and its fill color changes based on the state of the
     * letter box.
     * The label displays the letter of the letter box.
     */
    override val root = stackpane {
        rectangle {
            width = 50.0
            height = 50.0
            fill = Color.BLACK
            stroke = Color.LIGHTGRAY
            strokeWidth = 1.0

            /**
             * Listener for changes in the stateProperty.
             * When the state of the letter box changes, the fill color of the rectangle changes accordingly.
             */
            stateProperty.addListener { _, _, newValue ->
                when (newValue.toInt()) {
                    0 -> fill = Color.BLACK
                    1 -> fill = Color.LIGHTGRAY
                    2 -> fill = Color.YELLOW
                    3 -> fill = Color.GREEN
                }
            }
        }

        /**
         * Label that displays the letter of the letter box.
         */
        label(letterProperty) {
            textFill = Color.WHITE
            font = Font.font("Arial", FontWeight.BOLD, 14.0)
            prefWidth = 50.0
            prefHeight = 50.0
            alignment = Pos.CENTER
        }
    }

}
