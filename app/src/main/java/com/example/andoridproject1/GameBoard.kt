package com.example.andoridproject1

import android.util.Log

class GameBoard(val rows: Int, val cols: Int) {
    private val tag = "tag"
    private val gameBoard = IntArray(cols)

    init {
        for (i in 0..<cols) {
            gameBoard[i] = 5
        }
    }

    fun array() {
        Log.v(tag, "${gameBoard.asList()}")
    }
}