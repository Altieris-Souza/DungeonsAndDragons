package org.example.Breeds

import org.example.Character.Attribute

class Elfo : IBreeds {
    override fun getRaceName(): String {
        return "Elfo"
    }

    override fun applyRacialBonuses(attributes: Attribute) : Attribute{
        attributes.dexterity += 2

        return attributes
    }
}