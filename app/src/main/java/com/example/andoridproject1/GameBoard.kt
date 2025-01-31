package com.example.andoridproject1

import android.util.Log

class GameBoard(var rows: Int, var cols: Int) {
    private val tag = "tag"
    private val gameBoard = Array(rows) { IntArray(cols) }

    init {
        initGameBoard()
    }

    private fun initGameBoard(){
        for (i in 0..<rows) {
            for (j in 0..<cols) {
                gameBoard[i][j] = 5
            }
        }
    }

    fun changeSize(rows: Int,  cols: Int){
        this.rows = rows
        this.cols = cols

        initGameBoard()
    }

    private fun printGameBoard() {
        for (i in 0..<rows)
            Log.v(tag, "${gameBoard[i].asList()}")
    }

    fun array() {
        printGameBoard()
    }
}