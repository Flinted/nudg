package chris.did.presentation.nudgfactory

import chris.did.data.tagdata.RealmTagData
import chris.did.data.tagdata.SectionData
import chris.did.presentation.nudg.section.*
import java.util.*

/**
 * SectionFactory
 */
class SectionFactory(private val systemTags: HashSet<String>) : SectionParser,
    SectionDataConverter {

    companion object {
        private val DATE_TYPE = "DATE"
        private val SYSTEM_TYPE = "SYSTEM"
        private val USER_TYPE = "USER"
        private val STRING_TYPE = "STRING"
    }

    override fun parseSections(input: List<String>): List<Section> {
        if (input.isEmpty()) return listOf()
        val tags = extractTags(input)
        return when {
            tags.isEmpty() -> listOf(SystemTagSection(UUID.randomUUID(), "NoTag"))
            else           -> tags
        }
    }

    override fun convertToTagData(tag: Section): SectionData {
        val type = when (tag) {
            is DateTagSection   -> DATE_TYPE
            is SystemTagSection -> SYSTEM_TYPE
            is UserTagSection   -> USER_TYPE
            else                -> STRING_TYPE
        }
        return RealmTagData(tag.id.toString(), tag.value, type)
    }

    override fun convertToTag(data: SectionData): Section {
        val id = UUID.fromString(data.id)
        return when (data.type) {
            DATE_TYPE   -> DateTagSection(id, data.tag)
            SYSTEM_TYPE -> SystemTagSection(id, data.tag)
            USER_TYPE   -> UserTagSection(id, data.tag)
            else        -> StringSection(id, data.tag)
        }
    }

    override fun convertAllToTagData(tags: List<Section>) =
        tags.map { tag -> convertToTagData(tag) }

    override fun convertAllToTag(data: List<SectionData>) =
        data.map { tagData -> convertToTag(tagData) }

    private fun extractTags(input: List<String>): List<Section> {
        return input.filter { section -> StringParser.isTag(section) }
            .map { section -> createTag(UUID.randomUUID(), section) }
            .distinctBy { it.value }
            .toList()
    }

    private fun createTag(id: UUID, tagValue: String) = when {
        systemTags.contains(tagValue)    -> SystemTagSection(id, tagValue)
        StringParser.isDateTag(tagValue) -> DateTagSection(id, tagValue)
        StringParser.isTag(tagValue)     -> UserTagSection(id, tagValue)
        else                             -> StringSection(id, tagValue)
    }
}
