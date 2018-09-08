package chris.did.presentation.nudgfactory

import chris.did.presentation.nudg.tag.DateTag
import chris.did.presentation.nudg.tag.SystemTag
import chris.did.presentation.nudg.tag.UserTag
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Test

/**
 * TagFactoryTest
 */
class TagFactoryTest {

    private val systemTags = hashSetOf("MON", "TUE")
    private val tagParser = TagFactory(systemTags)

    private val testTags = listOf("#tag1", "#tag2", "#tag3", "#tag4")
    private val testDate = "2018/10/12"

    @Test
    fun canParseTagsCorrectly() {
        val testString = "Testing ${testTags[0]} ${testTags[1]} ${testTags[2]} ${testTags[3]}"
        val tags = tagParser.parseTags(testString)
        assertEquals(4, tags.size)
        tags.forEachIndexed { index, tag ->
            assertEquals(testTags[index], tag.getFormattedTag())
        }
    }

    @Test
    fun canParseTagsCorrectlyBetweenOtherText() {
        val testString =
            "Testing ${testTags[0]} testing ${testTags[1]} more text ${testTags[2]} ${testTags[3]}"
        val tags = tagParser.parseTags(testString)
        assertEquals(4, tags.size)
        tags.forEachIndexed { index, tag ->
            assertEquals(testTags[index], tag.getFormattedTag())
        }
    }

    @Test
    fun canParseDateTagsCorrectly() {
        val testString =
            "Testing ${testTags[0]} testing #$testDate more text ${testTags[2]} ${testTags[3]}"
        val tags = tagParser.parseTags(testString)
        assertEquals(4, tags.size)
        assertTrue(tags[0] is UserTag)
        assertTrue(tags[1] is DateTag)
        assertEquals(testDate, tags[1].tag)
        assertTrue(tags[2] is UserTag)
        assertTrue(tags[3] is UserTag)
    }

    @Test
    fun removesDuplicatedTags() {
        val testString =
            "Testing ${testTags[0]} testing ${testTags[0]} more text ${testTags[0]} ${testTags[0]}"
        val tags = tagParser.parseTags(testString)
        assertEquals(1, tags.size)
        assertEquals(testTags[0], tags[0].getFormattedTag())
    }

    @Test
    fun canDetectSystemTagsCorrectly() {
        val testString =
            "Testing ${testTags[0]} testing ${testTags[1]} more text #${systemTags.first()} ${testTags[3]}"
        val tags = tagParser.parseTags(testString)
        assertEquals(4, tags.size)
        assertTrue(tags[0] is UserTag)
        assertTrue(tags[1] is UserTag)
        assertTrue(tags[2] is SystemTag)
        assertEquals(systemTags.first(), tags[2].tag)
        assertTrue(tags[3] is UserTag)
    }
}
