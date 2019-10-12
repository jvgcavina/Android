package com.jvgc.kotlintutorial.classes

class WhiteWizard(name: String) : Wizard(name) {

    init {
        hitPoints = 140
    }

    override fun takeDamage(damage: Int) {
        super.takeDamage(damage / 2)
    }
}