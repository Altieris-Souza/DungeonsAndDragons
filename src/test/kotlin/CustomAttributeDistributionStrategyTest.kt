import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.example.Character.Attribute
import org.example.Character.CustomAttributeDistributionStrategy

class CustomAttributeDistributionStrategyTest {

    @Test
    fun `test attribute distribution`() {
        val attributes = Attribute()

        attributes.strength = 12
        attributes.dexterity = 10
        attributes.constitution = 14
        attributes.intelligence = 11
        attributes.wisdom = 9
        attributes.charisma = 8

        assertEquals(12, attributes.strength)
        assertEquals(10, attributes.dexterity)
        assertEquals(14, attributes.constitution)
        assertEquals(11, attributes.intelligence)
        assertEquals(9, attributes.wisdom)
        assertEquals(8, attributes.charisma)
    }
}