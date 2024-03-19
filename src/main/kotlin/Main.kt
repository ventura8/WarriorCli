package org.example.warrior

import org.example.warrior.game.*

fun main() {
//    val human = Human()
//    val orc = Orc()
//    FightEngine.fight(human,orc)

    val humans = Human.getHumans()
    val orcs = Orc.getOrcs()
    FightEngine.fight(humans,orcs)
}