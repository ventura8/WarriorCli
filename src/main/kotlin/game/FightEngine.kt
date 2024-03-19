package org.example.warrior.game

import java.lang.Thread.sleep

object FightEngine {

    private var turn = 0

    fun fight(warrior: Warrior, otherWarrior: Warrior): Warrior {
        println("!!! Fight starts between ${warrior.id()} and ${otherWarrior.id()}")
        println("${warrior.id()} description: $warrior")
        println("${otherWarrior.id()} description: $otherWarrior")

        while (warrior.getHealth() != 0 && otherWarrior.getHealth() != 0) {
            if (turn == 0) {
                warrior.attack(otherWarrior)
                turn = 1
            } else {
                otherWarrior.attack(warrior)
                turn = 0
            }
            sleep(1000)
        }

        val losingWarrior: Warrior
        val winningWarrior = if (warrior.getHealth() > 0) {
            losingWarrior = otherWarrior
            warrior

        } else {
            losingWarrior = warrior
            otherWarrior
        }
        println("!!! Winning Warrior is $winningWarrior with remainingHealth: ${winningWarrior.getHealth()}")
        return losingWarrior
    }

    fun fight(warriors: MutableList<Warrior>, otherWarriors: MutableList<Warrior>) {
        println("!!!!! Fight starts between ${warriors.size} warriors:\n$warriors\nversus ${otherWarriors.size} warriors:\n$otherWarriors")
        while (warriors.size != 0 && otherWarriors.size != 0) {
            val deadWarrior = fight(warriors.first(), otherWarriors.first())
            if (warriors.contains(deadWarrior)) {
                warriors.remove(deadWarrior)
            } else {
                otherWarriors.remove(deadWarrior)
            }
        }

        val winningWarriors = if (warriors.size > 0) {
            warriors
        } else {
            otherWarriors
        }
        println("!!!!! Winning Warriors are $winningWarriors")
    }
}