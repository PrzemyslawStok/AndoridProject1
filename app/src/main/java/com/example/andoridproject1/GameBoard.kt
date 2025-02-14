package com.example.andoridproject1

import android.util.Log
import kotlin.random.Random

class GameBoard(var rows: Int, var cols: Int) {
    private val tag = "tag"
    private var gameBoard = Array(rows) { IntArray(cols) }
    private var noTrials = 0

    init {
        initGameBoard()
        initLevel(2)
    }

    fun initLevel(noRandomSquares: Int) {
        for (square in 1..noRandomSquares) {
            val row = Random.nextInt(0, rows-1)
            val col = Random.nextInt(0, cols-1)
            this.gameBoard[row][col] = 1
        }

    }

    fun checkLevel(): Boolean {
        return true
    }

    fun getNoTrials(): Int {
        return this.noTrials
    }

    fun nextTrial() {
        this.noTrials += 1
    }

    private fun initGameBoard() {
        gameBoard = Array(rows) { IntArray(cols) }
        for (i in 0..<rows) {
            for (j in 0..<cols) {
                gameBoard[i][j] = 0
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