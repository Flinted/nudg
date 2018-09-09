package chris.did.presentation.nudgfactory

import chris.did.presentation.nudg.section.DateTagSection
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
        assertEquals(4, tags.size)
        tags.forEachIndexed { index, tag ->
            assertEquals(testTags[index], tag.value)
        }
    }

    @Test
    fun canParseTagsCorrectlyBetweenOtherText() {
        val testString =
            "Testing ${testTags[0]} testing ${testTags[1]} more text ${testTags[2]} ${testTags[3]}"
        val sectioned = StringParser.parseStringIntoSections(testString)
        val tags = tagParser.parseSections(sectioned)
        assertEquals(4, tags.size)
        tags.forEachIndexed { index, tag ->
            assertEquals(testTags[index], tag.value)
        }
    }

    @Test
    fun canParseDateTagsCorrectly() {
        val testString =
            "Testing ${testTags[0]} testing #$testDate more text ${testTags[2]} ${testTags[3]}"
        val sectioned = StringParser.parseStringIntoSections(testString)
        val tags = tagParser.parseSections(sectioned)
        assertEquals(4, tags.size)
        assertTrue(tags[0] is UserTagSection)
        assertTrue(tags[1] is DateTagSection)
        assertEquals("#$testDate", tags[1].value)
        assertTrue(tags[2] is UserTagSection)
        assertTrue(tags[3] is UserTagSection)
    }

    @Test
    fun removesDuplicatedTags() {
        val testString =
            "Testing ${testTags[0]} testing ${testTags[0]} more text ${testTags[0]} ${testTags[0]}"
        val sectioned = StringParser.parseStringIntoSections(testString)
        val tags = tagParser.parseSections(sectioned)
        assertEquals(1, tags.size)
        assertEquals(testTags[0], tags[0].value)
    }

    @Test
    fun canDetectSystemTagsCorrectly() {
        val testString =
            "Testing ${testTags[0]} testing ${testTags[1]} more text ${systemTags.first()} ${testTags[3]}"
        val sectioned = StringParser.parseStringIntoSections(testString)
        val tags = tagParser.parseSections(sectioned)
        assertEquals(4, tags.size)
        assertTrue(tags[0] is UserTagSection)
        assertTrue(tags[1] is UserTagSection)
        assertTrue(tags[2] is SystemTagSection)
        assertEquals(systemTags.first(), tags[2].value)
        assertTrue(tags[3] is UserTagSection)
    }
}
