package com.jvgc.kotlintutorial.classes

/**
 * Classes / Objects / Instances / Lists
 */

fun main() {
    val player1 = Player("Hyoga", "Cisne", 3, 4, 800)
    val player2 = Player("Shiryu", "Dragão", 2, 4, 750)
    val player3 = Player("Ikki", "Fênix", 2, 4, 700)
    // Constructors with default parameters
    val player4 = Player("Seiya", "Pégasus")
    val player5 = Player("Shun", "Andrômeda")

    // Object instance
    val p1Weapon = Weapon("Pó de Diamante", 12)
    player1.weapon = p1Weapon
    player1.show()

    player2.weapon = Weapon("Cólera do Dragão", 12)
    player2.show()

    player3.weapon = Weapon("Ave Fênix", 12)
    player3.show()

    player4.weapon = Weapon("Corrente de Andrômeda", 10)
    player4.show()

    player5.weapon = player4.weapon
    player5.show()

    player4.weapon = Weapon("Meteoro de Pégasus", 10)
    player4.show()

    val redPotion = Item("Red Potion", ItemType.POTION, 7.5)
    player3.inventory.add(redPotion)
    val crystalArmor = Item("Crystal Armor", ItemType.ARMOR, 80.0)
    player3.inventory.add(crystalArmor)
    player3.showInventory()

    // Pass an object to println command will use toString method to represent the object as a string
    println(player3)
}