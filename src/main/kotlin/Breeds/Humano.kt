package org.example.Breeds

import org.example.Character.Attribute

class Humano : IBreeds {
    override fun getRaceName(): String {
        return "Humano"
    }

    override fun applyRacialBonuses(attributes: Attribute) : Attribute {
        attributes.strength += 1
        attributes.dexterity += 1
        attributes.constitution += 1
        attributes.intelligence += 1
        attributes.wisdom += 1
        attributes.charisma += 1

        return attributes
    }
}