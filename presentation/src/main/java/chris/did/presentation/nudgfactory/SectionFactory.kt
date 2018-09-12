package chris.did.presentation.nudgfactory

import chris.did.data.room.sectiondata.RealmSectionData
import chris.did.presentation.nudg.section.DateTagSection
import chris.did.presentation.nudg.section.Section
import chris.did.presentation.nudg.section.SystemTagSection
import chris.did.presentation.nudg.section.UserTagSection
import io.realm.RealmList
import org.threeten.bp.DayOfWeek
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.temporal.TemporalAdjusters
import java.util.*

/**
 * SectionFactory
 */
class SectionFactory(private val systemTags: HashSet<String>) : SectionParser {

    companion object {
        private val DATE_TYPE = "DATE"
        private val SYSTEM_TYPE = "SYSTEM"
        private val USER_TYPE = "USER"
    }

    override fun parseSections(input: String): MutableList<Section> {
        if (input.isEmpty()) return mutableListOf()
        val tagSections = StringParser.parseStringIntoSections(input)
        val tags = extractTags(tagSections)
        return when {
            tags.isEmpty() -> mutableListOf(SystemTagSection(UUID.randomUUID(), SystemTags.NO_TAG))
            else           -> tags
        }
    }

    override fun convertToTagData(tag: Section): RealmSectionData {
        val type = when (tag) {
            is DateTagSection   -> DATE_TYPE
            is SystemTagSection -> SYSTEM_TYPE
            else                -> USER_TYPE
        }
        return RealmSectionData(tag.id.toString(), tag.value, type)
    }

    override fun convertToTag(data: RealmSectionData): Section {
        val id = UUID.fromString(data.id)
        return when (data.type) {
            DATE_TYPE   -> DateTagSection(id, data.tag)
            SYSTEM_TYPE -> SystemTagSection(id, data.tag)
            else        -> UserTagSection(id, data.tag)
        }
    }

    override fun convertAllToTagData(tags: List<Section>) =
        tags.flatMapTo(RealmList<RealmSectionData>()) { section -> listOf(convertToTagData(section)) }

    override fun convertAllToTag(data: List<RealmSectionData>) =
        data.map { tagData -> convertToTag(tagData) }

    private fun extractTags(input: List<String>): MutableList<Section> {
        return input.map { section -> createTag(UUID.randomUUID(), section) }.toMutableList()
    }

    private fun createTag(id: UUID, tagValue: String) = when {
        systemTags.contains(tagValue)    -> createSystemTag(id, tagValue)
        StringParser.isDateTag(tagValue) -> DateTagSection(id, tagValue)
        else                             -> UserTagSection(id, tagValue)
    }

    private fun createSystemTag(id: UUID, tagValue: String): Section {
        if (tagValue == SystemTags.DELETED) {
            return SystemTagSection(id, tagValue)
        }
        return createSystemDateTag(id, tagValue)
    }

    private fun createSystemDateTag(id: UUID, tagValue: String): DateTagSection {
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
        val dateTag = getNextOccurrenceOfDay(dateNow, dayId)
        return DateTagSection(id, dateTag)
    }

    private fun getNextOccurrenceOfDay(dateNow: LocalDate, dayId: DayOfWeek): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd")
        val adjustedDate = dateNow.with(TemporalAdjusters.next(dayId))
        return "#${adjustedDate.format(formatter)}"
    }
}

object SystemTags {
    val DELETED = "#deleted"
    val NO_TAG = "#notag"
    val TODAY = "#today"
    val TOMORROW = "#tomorrow"
    val MON = "#monday"
    val TUE = "#tuesday"
    val WED = "#wednesday"
    val THU = "#thursday"
    val FRI = "#friday"
    val SAT = "#saturday"
    val SUN = "#sunday"
    val TAGS = hashSetOf(DELETED, NO_TAG, TODAY, TOMORROW, MON, TUE, WED, THU, FRI, SAT, SUN)
}
