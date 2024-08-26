package org.example.Classes

import org.example.Character.Attribute

class Barbaro : IClasses {
    override fun getClassName(): String = "Bárbaro"

    override fun applyClassBonuses(attributes: Attribute)  : Attribute{
        attributes.strength += 2

        return attributes
    }

    override fun getHitDie(): Int {
        return 12
    }
}