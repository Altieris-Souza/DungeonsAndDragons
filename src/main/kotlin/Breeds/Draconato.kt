package org.example.Breeds

import org.example.Character.Attribute

class Draconato : IBreeds  {
    override fun getRaceName(): String {
        return "Draconato"
    }

    override fun applyRacialBonuses(attributes: Attribute) : Attribute{
        println()
        attributes.strength += 2
        attributes.charisma += 1

        return attributes
    }
}