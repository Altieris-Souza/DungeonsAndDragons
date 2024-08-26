package org.example

import org.example.Breeds.*
import org.example.Classes.Barbaro
import org.example.Classes.IClasses
import org.example.Character.Character
import org.example.Character.CustomAttributeDistributionStrategy
import org.example.Classes.Mago

fun main() {

    var chosenClazz : IClasses = Barbaro()
    var chosenBreed : IBreeds = Anao()
    var auxClazz = false
    var auxBreed = false

    while (!auxBreed) {
        println("\nEscolha a raça do personagem:")
        println("1. Anão")
        println("2. Elfo")
        println("3. Humano")
        println("4. Draconato")
        println("5. Gnomo")
        println("6. Halfing")
        println("7. Meio Elfo")
        println("8. Meio Orc")
        println("9. Tiefling")


        val classChoice = readLine()?.toIntOrNull()

        when (classChoice) {
            1 -> {
                chosenBreed = Anao()
                auxBreed = true
            }
            2 -> {
                chosenBreed = Elfo()
                auxBreed = true
            }
            3 -> {
                chosenBreed = Humano()
                auxBreed = true
            }
            4 -> {
                chosenBreed = Draconato()
                auxBreed = true
            }
            5 -> {
                chosenBreed = Gnomo()
                auxBreed = true
            }
            6 -> {
                chosenBreed = Halfing()
                auxBreed = true
            }
            7 -> {
                chosenBreed = MeioElfo()
                auxBreed = true
            }
            8 -> {
                chosenBreed = MeioOrc()
                auxBreed = true
            }
            9 -> {
                chosenBreed = Tiefling()
                auxBreed = true
            }
            else -> {
                println("\nEscolha inválida, tente novamente.")
            }
        }
    }

    while (!auxClazz) {
        println("\nEscolha a classe do personagem:")
        println("1. Bárbaro")
        println("2. Mago")

        val classChoice = readLine()?.toIntOrNull()

        when (classChoice) {
            1 -> {
                chosenClazz = Barbaro()
                auxClazz = true
            }
            2 -> {
                chosenClazz = Mago()
                auxClazz = true
            }
            else -> {
                println("\nEscolha inválida, tente novamente.")
            }
        }
    }

    println("\nDigite o nome do personagem")

    var nameCharacter = readLine().toString()

    val strategy = CustomAttributeDistributionStrategy()

    val character = Character(chosenBreed, chosenClazz, strategy)

    character.name = nameCharacter

    character.displayCharacterInfo()
}
