package org.example.Breeds

import org.example.Character.Attribute

class Halfing : IBreeds {
    override fun getRaceName(): String {
        return "Halfing"
    }

    override fun applyRacialBonuses(attributes: Attribute) : Attribute {
        attributes.dexterity += 2

        return attributes
    }
}