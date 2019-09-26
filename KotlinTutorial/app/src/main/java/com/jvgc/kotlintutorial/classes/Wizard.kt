package com.jvgc.kotlintutorial.classes

open class Wizard(name: String): Enemy(name, 30, 4) {

    override fun takeDamage(damage: Int) {
        super.takeDamage(damage / 2)
    }
}