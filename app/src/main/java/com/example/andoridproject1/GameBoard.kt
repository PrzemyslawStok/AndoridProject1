package com.example.andoridproject1

import android.util.Log

class GameBoard(var rows: Int, var cols: Int) {
    private val tag = "tag"
    private var gameBoard = Array(rows) { IntArray(cols) }

    init {
        initGameBoard()
    }

    private fun initGameBoard() {
        gameBoard = Array(rows) { IntArray(cols) }
        for (i in 0..<rows) {
            for (j in 0..<cols) {
                gameBoard[i][j] = 1
            }
        }
    }

    fun changeSize(rows: Int, cols: Int) {
        this.rows = rows
        this.cols = cols

        initGameBoard()
    }

    fun squareClicked(row: Int, col: Int) {
        for (i in row - 1..row + 1) {
            for (j in col - 1..col + 1)
                if (i in 0..<rows) {
                    if (j in 0..<cols) {
                        gameBoard[i][j] = if (gameBoard[i][j] == 1) 0 else 1
                    }
                }
        }
//        printGameBoard()
    }

    fun printGameBoard() {
        for (i in 0..<rows)
            Log.v(tag, "${gameBoard[i].asList()}")
    }

    fun getState(row: Int, col: Int): Int {
        return gameBoard[row][col]
    }
}