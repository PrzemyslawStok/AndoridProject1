package com.example.andoridproject1

import android.util.Log

class GameBoard(val rows: Int, val cols: Int) {
    private val tag = "tag"
    private val gameBoard = Array(rows) { IntArray(cols) }

    init {
        for (i in 0..<rows) {
            for (j in 0..<cols) {
                gameBoard[i][j] = 5
            }
        }
    }

    private fun printGameBoard(){
        Log.v(tag, "${gameBoard.asList()}")
    }

    fun array() {
        printGameBoard()
    }
}