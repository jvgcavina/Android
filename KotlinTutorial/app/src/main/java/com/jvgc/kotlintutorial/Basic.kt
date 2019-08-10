package com.jvgc.kotlintutorial

fun main() {
    println("Hello World")

    // Case insensitive variables
    var teste: String = "Teste1"
    var TESTE: String = "Teste2"
    println(teste)
    println(TESTE)

    // Variable initialization
    var firstInteger: Int = 32
    var secondInteger = 4
    var result: Int = firstInteger * secondInteger
    println(result)

    var weekly: Double = 250.0 / 4
    println(weekly)

    // Printing variables or expressions
    println("Result: ${firstInteger * 4}")
    println("My name is " + teste)
    println("My name is $teste")
    println("Printing \$ character...")

    // val stands for value
    val apples: Int = 5
    // var stands for variable
    var oranges: Int = 4

    // val can only be assigned once
    //apples = 3

    // var can be assigned anytime
    oranges = 3
}