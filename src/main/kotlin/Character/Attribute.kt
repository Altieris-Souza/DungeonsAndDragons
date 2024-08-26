package org.example.Character

data class Attribute(
    var strength: Int = 8,
    var dexterity: Int = 8,
    var constitution: Int = 8,
    var intelligence: Int = 8,
    var wisdom: Int = 8,
    var charisma: Int = 8
){
    fun getAttributes(): List<Pair<String, Int>> {
        return listOf(
            "Força" to strength,
            "Destreza" to dexterity,
            "Constituição" to constitution,
            "Inteligência" to intelligence,
            "Sabedoria" to wisdom,
            "Carisma" to charisma
        )
    }
}