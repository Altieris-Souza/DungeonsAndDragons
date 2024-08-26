package org.example.Classes

import org.example.Character.Attribute

class Mago : IClasses {
    override fun getClassName(): String = "Mago"

    override fun applyClassBonuses(attributes: Attribute) : Attribute{
        attributes.intelligence += 2

        return attributes
    }

    override fun getHitDie(): Int {
        return 6
    }
}