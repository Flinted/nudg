package chris.did.presentation.nudgfactory

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * NudgFactoryTest
 */
class NudgFactoryTest {

    private val systemTags = hashSetOf("MON", "TUE")
    private val tagParser = SectionFactory(systemTags)
    private val nudgFactory = NudgFactory(tagParser)

    private val testTags = listOf("#tag1", "#tag2", "#tag3", "#tag4")

    @Test
    fun canCreateNudgCorrectly() {
        val testString = "Testing ${testTags[0]} ${testTags[1]} ${testTags[2]} ${testTags[3]}"
        val nudg = nudgFactory.createNewNudg(testString)
        assertEquals(8, nudg.sections.size)
    }
}
