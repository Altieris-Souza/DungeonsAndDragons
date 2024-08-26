package org.example.Breeds

import org.example.Character.Attribute

class MeioElfo : IBreeds {
    override fun getRaceName(): String {
        return "MeioElfo"
    }

    override fun applyRacialBonuses(attributes: Attribute) : Attribute {
        attributes.charisma += 2

        return attributes
    }
}