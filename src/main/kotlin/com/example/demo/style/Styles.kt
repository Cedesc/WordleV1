package com.example.demo.style

import javafx.scene.text.FontWeight
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.px

class Styles : Stylesheet() {
    companion object {
        val wordBoard by cssclass()
        val keyBoard by cssclass()
        val keyboardButton by cssclass()
    }

    init {

        wordBoard {
            padding = box(40.px)
        }

        keyBoard {
            padding = box(40.px)
        }

        button and keyboardButton {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.SEMI_BOLD
            minWidth = 40.px
            minHeight = 40.px
        }

    }
}