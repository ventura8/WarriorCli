package org.example.warrior.game

class Human(override val name: String = Names.humanWarriorNames.random()) : Warrior(name,armor = 2){

    companion object {
        fun getHumans() = MutableList<Warrior>(10) { Human(name = Names.getNextHumanWarriorName() ?: "") }
    }
}