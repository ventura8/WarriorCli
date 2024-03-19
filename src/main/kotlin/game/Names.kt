package org.example.warrior.game

object Names {

    val humanWarriorNames = listOf(
        "Ares",
        "Xena",
        "Thor",
        "Artemis",
        "Odin",
        "Freya",
        "Spartacus",
        "Valkyrie",
        "Athena",
        "Conan"
    )

    val orcWarriorNames = listOf(
        "Grommash",
        "Thrall",
        "Durotan",
        "Gorgrak",
        "Zugor",
        "Mogor",
        "Gromnak",
        "Gruk",
        "Draka",
        "Nazgul"
    )

    var lastServedOrcIndex = -1
    fun getNextOrcWarriorName(): String? {
        lastServedOrcIndex++
        if (lastServedOrcIndex >= orcWarriorNames.size) {
            return null // Return null if all names have been served
        }
        return orcWarriorNames[lastServedOrcIndex]
    }

    var lastServedHumanIndex = -1
    fun getNextHumanWarriorName(): String? {
        lastServedHumanIndex++
        if (lastServedHumanIndex >= humanWarriorNames.size) {
            return null // Return null if all names have been served
        }
        return humanWarriorNames[lastServedHumanIndex]
    }
}