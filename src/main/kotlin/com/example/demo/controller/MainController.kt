package com.example.demo.controller

import com.example.demo.model.Game
import tornadofx.*

class MainController : Controller() {

    val resultWord: String = "WORD"

    val numberOfRows: Int = 5

    val gameInstance: Game = Game(resultWord, numberOfRows)

}