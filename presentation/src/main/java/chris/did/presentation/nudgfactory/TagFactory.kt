package chris.did.presentation.nudgfactory

import chris.did.data.tagdata.RealmTagData
import chris.did.data.tagdata.TagData
import chris.did.presentation.nudg.tag.DateTag
import chris.did.presentation.nudg.tag.SystemTag
import chris.did.presentation.nudg.tag.Tag
import chris.did.presentation.nudg.tag.UserTag
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * TagFactory
 */
class TagFactory(private val systemTags: HashSet<String>) : TagParser, TagDataConverter {

    companion object {
        private val dateRegex = "\\d{4}\\/\\d{2}\\/\\d{2}"
        private val tagRegex = "#($dateRegex|(\\w+))"
        private val datePattern = Pattern.compile(dateRegex)
        private val DATE_TYPE = "DATE"
        private val SYSTEM_TYPE = "SYSTEM"
        private val USER_TYPE = "USER"
    }

    override fun parseTags(string: String): List<Tag> {
        if (string.isEmpty()) return listOf()
        val matcher = createTagMatcher(string)
        val tags = extractTags(matcher)
        return when {
            tags.isEmpty() -> listOf(SystemTag(UUID.randomUUID(), "NoTag"))
            else           -> tags
        }
    }

    override fun convertToTagData(tag: Tag): TagData {
        val type = when (tag) {
            is DateTag   -> DATE_TYPE
            is SystemTag -> SYSTEM_TYPE
            else         -> USER_TYPE
        }
        return RealmTagData(tag.id.toString(), tag.tag, type)
    }

    override fun convertToTag(data: TagData): Tag {
        val id = UUID.fromString(data.id)
        return when (data.type) {
            DATE_TYPE   -> DateTag(id, data.tag)
            SYSTEM_TYPE -> SystemTag(id, data.tag)
            else        -> UserTag(id, data.tag)
        }
    }

    override fun convertAllToTagData(tags: List<Tag>) = tags.map { tag -> convertToTagData(tag) }

    override fun convertAllToTag(data: List<TagData>) =
        data.map { tagData -> convertToTag(tagData) }

    private fun extractTags(matcher: Matcher): List<Tag> {
        val tags = mutableListOf<Tag>()
        while (matcher.find()) {
            val tagValue = matcher.group(1) ?: continue
            val tag = createTag(UUID.randomUUID(), tagValue)
            tags.add(tag)
        }
        return tags.distinctBy { it.tag }.toList()
    }

    private fun createTag(id: UUID, tagValue: String) = when {
        systemTags.contains(tagValue)           -> SystemTag(id, tagValue)
        datePattern.matcher(tagValue).matches() -> DateTag(id, tagValue)
        else                                    -> UserTag(id, tagValue)
    }

    private fun createTagMatcher(string: String): Matcher {
        val pattern = Pattern.compile(tagRegex)
        return pattern.matcher(string)
    }
}