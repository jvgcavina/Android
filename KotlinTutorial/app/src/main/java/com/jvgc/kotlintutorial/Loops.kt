package com.jvgc.kotlintutorial

fun main() {
    // LOOPS
    // Sample 1 - for loop .. (start index inclusive / end index inclusive)
    println("Sample 1")
    for (i in 0..10) {
        println(i)
    }

    // Sample 2 - for loop .. with step (start index inclusive / end index inclusive)
    println("\nSample 2")
    for (i in 0..10 step 2) {
        println(i)
    }

    // Sample 3 - for loop until (start index inclusive / end index exclusive)
    println("\nSample 3")
    for (i in 0 until 10) {
        println(i)
    }

    // Sample 4 - for loop until with step (start index inclusive / end index exclusive)
    println("\nSample 4")
    for (i in 0 until 10 step 2) {
        println(i)
    }

    // Sample 5 - for loop downTo (start index inclusive / end index inclusive)
    println("\nSample 5")
    for (i in 10 downTo 0) {
        println(i)
    }

    // Sample 6 - for loop downTo with step (start index inclusive / end index inclusive)
    println("\nSample 6")
    for (i in 10 downTo 0 step 2) {
        println(i)
    }

    // Challenge
    println("\nChallenge - Solution 1")
    for (i in 0..100) {
        if (i % 3 == 0 && i % 5 == 0) {
            println(i)
        }
    }

    // A little bit more efficient
    println("\nChallenge - Solution 2")
    for (i in 0..100 step 3) {
        if (i % 5 == 0) {
            println(i)
        }
    }

    // Sample 7 - for loop to set objects (iterate through all items of the set
    val strings = ArrayList<String>()
    strings.add("Item1")
    strings.add("Item2")
    strings.add("Item3")
    strings.add("Item4")

    for (s:String in strings) {
        println(s)
    }

    // Sample 8 - while loop (iterate while the condition is true)
    var j = 0
    while (j < 10) {
        println(j)
        j++
    }

    // Sample 9 - do while loop (iterate while the condition is true, but at least one time)
    var k = 0
    do {
        println(k)
        k++
    } while(k < 10)
}