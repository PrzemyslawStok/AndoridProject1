package com.example.andoridproject1

import android.util.Log

class GameBoard(var rows: Int, var cols: Int) {
    private val tag = "tag"
    private var gameBoard = Array(rows) { IntArray(cols) }

    init {
        initGameBoard()
    }

    private fun initGameBoard(){
        gameBoard = Array(rows) { IntArray(cols) }
        for (i in 0..<rows) {
            for (j in 0..<cols) {
                gameBoard[i][j] = 1
            }
        }
    }

    fun changeSize(rows: Int,  cols: Int){
        this.rows = rows
        this.cols = cols

        initGameBoard()
    }

    fun squareClicked(i: Int, j: Int){
        if(i in 1..<rows){
            if(j in 1..<cols){

            }
        }
    }

    fun printGameBoard() {
        for (i in 0..<rows)
            Log.v(tag, "${gameBoard[i].asList()}")
    }
}