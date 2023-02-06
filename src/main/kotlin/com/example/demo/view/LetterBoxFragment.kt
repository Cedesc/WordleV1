package com.example.demo.view

import com.example.demo.model.LetterBox
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*

class LetterBoxFragment : Fragment() {
    val letterBox: LetterBox by param()

    private val letterProperty = SimpleStringProperty(letterBox.letter.toString())
    private val stateProperty = SimpleIntegerProperty(letterBox.state)

    init {
        letterProperty.bind(letterBox.letterProperty)
        stateProperty.bind(letterBox.stateProperty)
    }


    override val root = stackpane {
        rectangle {
            width = 50.0
            height = 50.0
            fill = Color.BLACK
            stroke = Color.LIGHTGRAY
            strokeWidth = 1.0

            stateProperty.addListener { _, _, newValue ->
                when (newValue.toInt()) {
                    0 -> fill = Color.BLACK
                    1 -> fill = Color.LIGHTGRAY
                    2 -> fill = Color.YELLOW
                    3 -> fill = Color.GREEN
                }
            }
        }

        label(letterProperty) {
            textFill = Color.WHITE
            font = Font.font("Arial", FontWeight.BOLD, 14.0)
            prefWidth = 50.0
            prefHeight = 50.0
            alignment = Pos.CENTER
        }
    }

}
