package com.example.demo.style

import javafx.scene.text.FontWeight
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.px

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
        val keyboardButton by cssclass()
    }

    init {
        label and heading {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
        }
    }

    init {
        button and keyboardButton {
            padding = box(10.px)
            fontSize = 20.px
            minWidth = 40.px
            minHeight = 40.px
        }
    }
}