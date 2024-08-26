import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.example.Breeds.Anao
import org.example.Classes.Barbaro
import org.example.Character.Character
import org.example.Character.Attribute
import org.example.Character.CustomAttributeDistributionStrategy

class CharacterTest {

    @Test
    fun `test character instantiation with race and class`() {
        val breed = Anao()
        val clazz = Barbaro()

        val strategy = CustomAttributeDistributionStrategy()

        val character = Character(breed, clazz, strategy).apply {
            name = "TestePersonagem"
        }

        assertEquals("TestePersonagem", character.name)

        assertEquals("Anão", character.breed.getRaceName())
        assertEquals("Bárbaro", character.clazz.getClassName())
    }
}