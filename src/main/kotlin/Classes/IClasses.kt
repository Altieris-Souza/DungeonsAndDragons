package org.example.Classes

import org.example.Character.Attribute

interface IClasses {
    fun getClassName(): String

    fun applyClassBonuses(attributes: Attribute) : Attribute

    fun getHitDie(): Int
}