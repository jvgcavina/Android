package com.jvgc.kotlintutorial

fun main() {
    // CONDITIONAL
    // Sample 1 - If as statement
    val numberOfLives = 3
    val isGameOver = numberOfLives < 1

    if (isGameOver) {
        println("Game Over!")
    } else {
        println("You're still alive!")
    }

    // Sample 2 - If as expression
    println("\nHow old are you?")
    val age = readLine()!!.toInt()
    println("Age is $age")

    val message: String
    // To use this resource the last line of each if block should return values of the same type
    message = if (age < 18) {
        val a = 1
        println("Testing if as expression")
        "You're underage"
    } else {
        "You're overage"
    }

    println(message)
}