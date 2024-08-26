package org.example.Breeds

import org.example.Character.Attribute

interface IBreeds {
    fun getRaceName(): String
    fun applyRacialBonuses(attributes: Attribute) : Attribute
}