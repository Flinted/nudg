package chris.did.presentation.nudgfactory

import chris.did.data.tagdata.RealmSectionData
import chris.did.data.tagdata.SectionData
import chris.did.presentation.nudg.section.*
import org.threeten.bp.DayOfWeek
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.temporal.TemporalAdjusters
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
        return RealmSectionData(tag.id.toString(), tag.value, type)
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
        return input.map { section -> createTag(UUID.randomUUID(), section) }.toList()
    }

    private fun createTag(id: UUID, tagValue: String) = when {
        systemTags.contains(tagValue)    -> createSystemTag(id, tagValue)
        StringParser.isDateTag(tagValue) -> DateTagSection(id, tagValue)
        StringParser.isTag(tagValue)     -> UserTagSection(id, tagValue)
        else                             -> StringSection(id, tagValue)
    }

    private fun createSystemTag(id: UUID, tagValue: String): Section {
        val dateNow = LocalDate.now()
        dateNow.dayOfWeek.value
        val dayId = when (tagValue) {
            SystemTags.TODAY    -> dateNow.dayOfWeek
            SystemTags.TOMORROW -> dateNow.plusDays(1).dayOfWeek
            SystemTags.MON      -> DayOfWeek.MONDAY
            SystemTags.TUE      -> DayOfWeek.TUESDAY
            SystemTags.WED      -> DayOfWeek.WEDNESDAY
            SystemTags.THU      -> DayOfWeek.THURSDAY
            SystemTags.FRI      -> DayOfWeek.FRIDAY
            SystemTags.SAT      -> DayOfWeek.SATURDAY
            SystemTags.SUN      -> DayOfWeek.SUNDAY
            else                -> dateNow.dayOfWeek
        }
        val dateTag = getNextOccurenceOfDay(dateNow, dayId)
        return DateTagSection(id, dateTag)
    }

    private fun getNextOccurenceOfDay(dateNow: LocalDate, dayId: DayOfWeek): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd")
        val adjustedDate = dateNow.with(TemporalAdjusters.next(dayId))
        return "#${adjustedDate.format(formatter)}"
    }
}

object SystemTags {
    val NO_TAG = "#NoTag"
    val TODAY = "#Today"
    val TOMORROW = "#Tomorrow"
    val MON = "#MON"
    val TUE = "#TUE"
    val WED = "#WED"
    val THU = "#THU"
    val FRI = "#FRI"
    val SAT = "#SAT"
    val SUN = "#SUN"
    val TAGS = hashSetOf(NO_TAG, TODAY, TOMORROW, MON, TUE, WED, THU, FRI, SAT, SUN)
}
