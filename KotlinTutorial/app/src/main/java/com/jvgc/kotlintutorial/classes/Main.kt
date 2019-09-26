package com.jvgc.kotlintutorial.classes

/**
 * Classes / Objects / Instances / Lists / Encapsulation
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

    // ENCAPSULATION - Function addToInventory/removeFromInventory used to access private member of Player class
    val redPotion = Item("Red Potion", ItemType.POTION, 7.5)
    player3.addToInventory(redPotion)
    val crystalArmor = Item("Crystal Armor", ItemType.ARMOR, 80.0)
    player3.addToInventory(crystalArmor)
    player3.showInventory()

    if (player3.removeFromInventory(redPotion)) {
        player3.showInventory()
    } else {
        println("${player3.name} does not have ${redPotion.name}")
    }

    if (player2.removeFromInventory(redPotion)) {
        player2.showInventory()
    } else {
        println("${player2.name} does not have ${redPotion.name}")
    }

    // FUNCTION OVERLOAD
    if (player3.removeFromInventory(crystalArmor.name)) {
        player3.showInventory()
    } else {
        println("${player3.name} does not have ${crystalArmor.name}")
    }

    if (player2.removeFromInventory(crystalArmor.name)) {
        player2.showInventory()
    } else {
        println("${player2.name} does not have ${crystalArmor.name}")
    }

    // Pass an object to println command will use toString method to represent the object as a string
    println(player3)


    // INHERITANCE
    val enemy = Enemy("test enemy", 10, 3)
    println(enemy)

    enemy.takeDamage(4)
    println(enemy)

    val uglyTroll = Troll("Ugly Troll", 20, 3)
    println(uglyTroll)
    uglyTroll.takeDamage(8)
    println(uglyTroll)

    val merlin = Wizard("Merlin")
    println(merlin)
    merlin.takeDamage(6)
    println(merlin)

    val gandalf = WhiteWizard("Gandalf")
    println(gandalf)
    gandalf.takeDamage(6)
    println(gandalf)
}