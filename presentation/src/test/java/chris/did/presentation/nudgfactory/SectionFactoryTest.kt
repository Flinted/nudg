package chris.did.presentation.nudgfactory

import chris.did.presentation.nudg.section.DateTagSection
import chris.did.presentation.nudg.section.StringSection
import chris.did.presentation.nudg.section.SystemTagSection
import chris.did.presentation.nudg.section.UserTagSection
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Test

/**
 * SectionFactoryTest
 */
class SectionFactoryTest {

    private val systemTags = hashSetOf("#MON", "#TUE")
    private val tagParser = SectionFactory(systemTags)

    private val testTags = listOf("#tag1", "#tag2", "#tag3", "#tag4")
    private val testDate = "2018/10/12"

    @Test
    fun canParseTagsCorrectly() {
        val testString = "Testing ${testTags[0]} ${testTags[1]} ${testTags[2]} ${testTags[3]}"
        val sectioned = StringParser.parseStringIntoSections(testString)
        val tags = tagParser.parseSections(sectioned)
        assertEquals(8, tags.size)
        tags.forEachIndexed { index, tag ->
            assertEquals(sectioned[index], tag.value)
        }
    }

    @Test
    fun canParseTagsCorrectlyBetweenOtherText() {
        val testString =
            "Testing ${testTags[0]} testing ${testTags[1]} more text ${testTags[2]} ${testTags[3]}"
        val sectioned = StringParser.parseStringIntoSections(testString)
        val tags = tagParser.parseSections(sectioned)
        assertEquals(8, tags.size)
        tags.forEachIndexed { index, tag ->
            assertEquals(sectioned[index], tag.value)
        }
    }

    @Test
    fun canParseDateTagsCorrectly() {
        val testString =
            "Testing ${testTags[0]} testing #$testDate more text ${testTags[2]} ${testTags[3]}"
        val sectioned = StringParser.parseStringIntoSections(testString)
        val tags = tagParser.parseSections(sectioned)
        assertEquals(8, tags.size)
        assertTrue(tags[0] is StringSection)
        assertTrue(tags[1] is UserTagSection)
        assertTrue(tags[2] is StringSection)
        assertTrue(tags[3] is DateTagSection)
        assertEquals("#$testDate", tags[3].value)
        assertTrue(tags[4] is StringSection)
        assertTrue(tags[5] is UserTagSection)
        assertTrue(tags[6] is StringSection)
        assertTrue(tags[7] is UserTagSection)
    }

    @Test
    fun canDetectSystemTagsCorrectly() {
        val testString =
            "Testing ${testTags[0]} testing ${testTags[1]} more text ${systemTags.first()} ${testTags[3]}"
        val sectioned = StringParser.parseStringIntoSections(testString)
        val tags = tagParser.parseSections(sectioned)
        assertEquals(8, tags.size)
        assertTrue(tags[0] is StringSection)
        assertTrue(tags[1] is UserTagSection)
        assertTrue(tags[2] is StringSection)
        assertTrue(tags[3] is UserTagSection)
        assertTrue(tags[4] is StringSection)
        assertTrue(tags[5] is SystemTagSection)
        assertEquals(systemTags.first(), tags[5].value)
        assertTrue(tags[6] is StringSection)
        assertTrue(tags[7] is UserTagSection)
    }
}
