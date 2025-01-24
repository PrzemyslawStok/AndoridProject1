package com.example.andoridproject1

import android.util.Log

class GameBoard(val rows: Int, val cols: Int) {
    val TAG = "tag"
    fun array() {
        val numbersArray = arrayOf(1, 2, 3, 4, 5)
        Log.v(TAG, "${numbersArray.asList()}")
        println(numbersArray)
    }
}