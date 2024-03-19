package org.example.warrior.game

class Orc(override val name: String = Names.orcWarriorNames.random()): Warrior(
    name,
    maxHealth = 120,
    damage = 7,
    luck = 0.5
) {

    companion object {
        fun getOrcs() = MutableList<Warrior>(10) { Orc(name = Names.getNextOrcWarriorName() ?: "") }
    }
}