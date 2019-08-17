package com.jvgc.kotlintutorial.classes

// Constructor with parameters that have default values. These parameters are optional on instantiation.
class Player(
    val name: String,
    val constellation: String,
    var lives: Int = 3,
    var level: Int = 1,
    var score: Int = 0) {

    var weapon = Weapon("Fist", 5)
    var inventory = ArrayList<Item>()

    // Overriding function
    override fun toString(): String {
        return """
            $name de $constellation
            Lives: $lives Level: $level Score: $score
            Blow: $weapon
            """
    }

    fun show() {
        // Three double quotes to print in several lines
        println("""
            $name de $constellation
            Lives: $lives Level: $level Score: $score
            Blow: $weapon
            """)
    }

    fun showInventory() {
        println("$name's Inventory")
        for (item in inventory) {
            println(item)
        }
        println("=============================")
    }
}