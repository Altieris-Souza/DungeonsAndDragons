package org.example.Character

import org.example.Breeds.IBreeds
import org.example.Classes.IClasses

open class Character(var breed: IBreeds, var clazz: IClasses, var strategy: IDistribution) {
    var name: String = ""
    var life: Int = 10
    val attributes = Attribute()
    var bonus1: Attribute? = null
    var newLife = 0

    init {
        // Distribui pontos de atributos
        strategy.distributeAttributes(attributes)

        // Aplica bônus e calcula a vida
        applyBonuses()
        calculateLife()
    }

    public fun applyBonuses() {
        // Aplica bônus raciais e de classe
        breed.applyRacialBonuses(attributes)
        val attributesAfterClassBonuses = clazz.applyClassBonuses(attributes)
        bonus1 = attributesAfterClassBonuses
    }

    private fun calculateLife() {
        newLife = when {
            bonus1?.constitution == 1 -> -5
            bonus1?.constitution in 2..3 -> -4
            bonus1?.constitution in 4..5 -> -3
            bonus1?.constitution in 6..7 -> -2
            bonus1?.constitution in 8..9 -> -1
            bonus1?.constitution in 10..11 -> 0
            bonus1?.constitution in 12..13 -> 1
            bonus1?.constitution in 14..15 -> 2
            bonus1?.constitution in 16..17 -> 3
            bonus1?.constitution in 18..19 -> 4
            bonus1?.constitution in 20..21 -> 5
            bonus1?.constitution in 22..23 -> 6
            bonus1?.constitution in 24..25 -> 7
            bonus1?.constitution in 26..27 -> 8
            bonus1?.constitution in 28..29 -> 9
            bonus1?.constitution ?: 0 >= 30 -> 10
            else -> 0
        }
    }

    fun displayCharacterInfo() {
        println("Name: $name")
        println("Life: ${10 + newLife}")
        println("Race: ${breed.getRaceName()}")
        println("Class: ${clazz.getClassName()}")

        println("Attributes:")
        attributes.getAttributes().forEach { (name, value) ->
            println("  $name: $value")
        }
    }
}