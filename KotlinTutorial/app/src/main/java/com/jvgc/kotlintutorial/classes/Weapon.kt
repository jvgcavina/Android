package com.jvgc.kotlintutorial.classes

class Weapon(val name: String, var damageInflicted: Int) {

    override fun toString(): String {
        return "$name \\ Damage: $damageInflicted"
    }
}