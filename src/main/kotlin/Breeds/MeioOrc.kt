package org.example.Breeds

import com.sun.source.doctree.AttributeTree
import org.example.Character.Attribute

class MeioOrc  : IBreeds  {
    override fun getRaceName(): String {
        return "MeioOrc"
    }

    override fun applyRacialBonuses(attributes: Attribute) : Attribute {
        attributes.strength += 2
        attributes.constitution += 1

        return attributes
    }
}