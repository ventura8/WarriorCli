package org.example.warrior.game

import kotlin.random.Random

open class Warrior(
    open val name: String = "",
    val maxHealth: Int = 100,
    val damage: Int = 5,
    open val luck: Double = 0.8,
    open val armor: Int = 0
) {
    private var remainingHealth = maxHealth
    private val id: Int = this.javaClass.hashCode()

    fun getHealth() = remainingHealth

    fun takeDamage(damage: Int) {
        if (remainingHealth <= 0) {
            println("${this.id()} already dead")
        } else {
            var absorbedDamage = damage - armor
            if (absorbedDamage <= 0) absorbedDamage = 0
            remainingHealth -= absorbedDamage
            if (remainingHealth < 0) remainingHealth = 0
            println("${this.id()} has $armor armor, took $absorbedDamage damage. remainingHealth: $remainingHealth")
        }
    }

    fun attack(other: Warrior) {
        if (Random.nextDouble() <= luck) {
            println("${this.id()} hit ${other.id()} with $damage damage")
            other.takeDamage(damage)
        } else {
            println("${this.id()} missed")
        }
    }

    override fun toString() = """
    {
        id = $id
        name = $name
        maxHealth = $maxHealth
        remainingHealth = $remainingHealth
        damage = $damage
        luck = $luck
        armor = $armor
    }
    """.trimIndent()

    fun id() = this.javaClass.simpleName + "@" + this.javaClass.hashCode()

}