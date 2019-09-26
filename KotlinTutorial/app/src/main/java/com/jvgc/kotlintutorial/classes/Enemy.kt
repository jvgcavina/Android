package com.jvgc.kotlintutorial.classes

open class Enemy(val name: String, var hitPoints: Int, var lives: Int) {

    open fun takeDamage(damage: Int) {
        val remainingHitPoints = hitPoints - damage
        if (remainingHitPoints > 0) {
            hitPoints = remainingHitPoints
            println("$name took $damage points of damage and has $hitPoints left")
        } else {
            lives -= 1
            println("Lost a life. Lives left: $lives")
        }
    }

    override fun toString(): String {
        return "Name: $name / HitPoints: $hitPoints / Lives: $lives"
    }
}