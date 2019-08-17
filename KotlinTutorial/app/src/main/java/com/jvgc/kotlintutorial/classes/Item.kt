package com.jvgc.kotlintutorial.classes

enum class ItemType {
    POTION, ARMOR
}

class Item(val name: String, val type: ItemType, val value: Double) {

    override fun toString(): String {
        return "$name \\ $type \\ $value"
    }
}