package chris.did.presentation.nudgfactory

import chris.did.presentation.nudg.tag.DateTag
import chris.did.presentation.nudg.tag.SystemTag
import chris.did.presentation.nudg.tag.Tag
import chris.did.presentation.nudg.tag.UserTag
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * TagFactory
 */
class TagFactory(private val systemTags: HashSet<String>) : TagParser {
    private val dateRegex = "\\d{4}\\/\\d{2}\\/\\d{2}"
    private val tagRegex = "#($dateRegex|(\\w+))"
    private val datePattern = Pattern.compile(dateRegex)

    override fun parseTags(string: String): List<Tag> {
        if (string.isEmpty()) return listOf()
        val matcher = createTagMatcher(string)
        return extractTags(matcher)
    }

    private fun extractTags(matcher: Matcher): List<Tag> {
        val tags = mutableListOf<Tag>()
        while (matcher.find()) {
            val tagValue = matcher.group(1) ?: continue
            val tag = createTag(tagValue)
            tags.add(tag)
        }
        return tags.distinctBy { it.tag }.toList()
    }

    private fun createTag(tagValue: String) = when {
        systemTags.contains(tagValue)           -> SystemTag(tagValue)
        datePattern.matcher(tagValue).matches() -> DateTag(tagValue)
        else                                    -> UserTag(tagValue)
    }

    private fun createTagMatcher(string: String): Matcher {
        val pattern = Pattern.compile(tagRegex)
        return pattern.matcher(string)
    }
}