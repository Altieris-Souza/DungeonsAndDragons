package org.example.Breeds

import org.example.Character.Attribute

class Tiefling  : IBreeds  {
    override fun getRaceName(): String {
        return "Tiefling"
    }

    override fun applyRacialBonuses(attributes: Attribute) : Attribute {
        attributes.charisma += 2
        attributes.intelligence += 1

        return attributes
    }
}