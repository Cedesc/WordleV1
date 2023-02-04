package com.example.demo.controller

import com.example.demo.model.Game
import com.example.demo.view.viewmodel.WordBoardModel
import tornadofx.*

class MainController : Controller() {

    private val wordBoardModel: WordBoardModel by inject()



    val resultWord: String = "WORD"

    val numberOfRows: Int = 5

    val gameInstance: Game = Game(resultWord, numberOfRows)

}