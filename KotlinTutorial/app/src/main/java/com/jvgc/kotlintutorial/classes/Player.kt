package com.jvgc.kotlintutorial.classes

// Constructor with parameters that have default values. These parameters are optional on instantiation.
class Player(
    val name: String,
    val constellation: String,
    var lives: Int = 3,
    var level: Int = 1,
    var score: Int = 0) {

    fun show() {
        // Three double quotes to print in several lines
        println("""
            $name de $constellation
            Lives: $lives Level: $level Score: $score
            """)
    }
}