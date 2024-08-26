package org.example.Character

import org.example.Classes.IClasses

private val costTable = mapOf(
    8 to 0, 9 to 1, 10 to 2, 11 to 3, 12 to 4,
    13 to 5, 14 to 7, 15 to 9
)

class CustomAttributeDistributionStrategy : IDistribution {

    private val totalPoints = 27

    override fun distributeAttributes(attributes: Attribute) {
        var remainingPoints = totalPoints

        println("\nVocê tem $totalPoints pontos para distribuir entre os seguintes atributos:")
        println("Força, Destreza, Constituição, Inteligência, Sabedoria, Carisma")

        fun askForAttribute(name: String, currentValue: Int): Int {
            var level: Int

            do {
                println("\nDigite o nível para $name (restantes: $remainingPoints):")

                level = readLine()?.toIntOrNull() ?: 0

                if (level < 8 || level > 15) {
                    println("\nNível inválido! O valor máximo é 15. Digite um valor válido entre 8 e 15.")
                    continue
                }

                val newValue = level
                val cost = costTable[newValue] ?: 0

                if (cost > remainingPoints) {
                    println("\nPontos insuficientes! O custo para $name com o valor $newValue é $cost. Digite um valor válido entre 8 e 15.")
                }

            } while (level < 8 || level > 15 || costTable[level] ?: 0 > remainingPoints)

            return level
        }

        val attributesMap = mutableMapOf<String, (Attribute) -> Int>(
            "Força" to { attributes.strength },
            "Destreza" to { attributes.dexterity },
            "Constituição" to { attributes.constitution },
            "Inteligência" to { attributes.intelligence },
            "Sabedoria" to { attributes.wisdom },
            "Carisma" to { attributes.charisma }
        )

        val settersMap = mutableMapOf<String, (Attribute, Int) -> Unit>(
            "Força" to { attr, value -> attr.strength = value },
            "Destreza" to { attr, value -> attr.dexterity = value },
            "Constituição" to { attr, value -> attr.constitution = value },
            "Inteligência" to { attr, value -> attr.intelligence = value },
            "Sabedoria" to { attr, value -> attr.wisdom = value },
            "Carisma" to { attr, value -> attr.charisma = value }
        )

        attributesMap.forEach { (name, getter) ->
            if (remainingPoints > 0) {
                val currentValue = getter(attributes)
                val level = askForAttribute(name, currentValue)
                val cost = costTable[level] ?: 0

                settersMap[name]?.invoke(attributes, level)

                remainingPoints -= cost
            }
        }

        if (remainingPoints < 0) {
            println("\nVocê excedeu o número máximo de pontos disponíveis. Ajustando atributos.")
            adjustAttributes(attributes, -remainingPoints)
        }


//        println("Distribuição final de atributos:")
//        println("Força: ${attributes.strength}")
//        println("Destreza: ${attributes.dexterity}")
//        println("Constituição: ${attributes.constitution}")
//        println("Inteligência: ${attributes.intelligence}")
//        println("Sabedoria: ${attributes.wisdom}")
//        println("Carisma: ${attributes.charisma}")
    }

    private fun adjustAttributes(attributes: Attribute, excess: Int) {
        var remainingExcess = excess

        val attributesMap = mutableMapOf<String, (Attribute) -> Int>(
            "Força" to { attributes.strength },
            "Destreza" to { attributes.dexterity },
            "Constituição" to { attributes.constitution },
            "Inteligência" to { attributes.intelligence },
            "Sabedoria" to { attributes.wisdom },
            "Carisma" to { attributes.charisma }
        )

        val settersMap = mutableMapOf<String, (Attribute, Int) -> Unit>(
            "Força" to { attr, value -> attr.strength = value },
            "Destreza" to { attr, value -> attr.dexterity = value },
            "Constituição" to { attr, value -> attr.constitution = value },
            "Inteligência" to { attr, value -> attr.intelligence = value },
            "Sabedoria" to { attr, value -> attr.wisdom = value },
            "Carisma" to { attr, value -> attr.charisma = value }
        )

        for ((name, getter) in attributesMap) {
            if (remainingExcess <= 0) break

            val currentValue = getter(attributes)
            if (currentValue > 8) {
                val newValue = currentValue - 1
                val costDifference = (costTable[currentValue] ?: 0) - (costTable[newValue] ?: 0)
                if (remainingExcess >= costDifference) {
                    settersMap[name]?.invoke(attributes, newValue)
                    remainingExcess -= costDifference
                }
            }
        }
    }
}