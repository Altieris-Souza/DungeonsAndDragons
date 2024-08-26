package org.example.Breeds

import org.example.Character.Attribute

class Gnomo : IBreeds {
    override fun getRaceName(): String {
        return "Gnomo"
    }

    override fun applyRacialBonuses(attributes: Attribute) : Attribute{
        attributes.intelligence += 2

        return attributes
    }
}