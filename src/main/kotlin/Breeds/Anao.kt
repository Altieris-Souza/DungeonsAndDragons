package org.example.Breeds

import org.example.Character.Attribute

class Anao : IBreeds {
    override fun getRaceName(): String {
        return "Anão"
    }

    override fun applyRacialBonuses(attributes: Attribute) : Attribute {
        attributes.constitution += 2

        return attributes
    }
}