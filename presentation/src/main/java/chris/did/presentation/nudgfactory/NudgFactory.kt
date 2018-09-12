package chris.did.presentation.nudgfactory

import chris.did.data.room.nudgdata.RealmNudgData
import chris.did.presentation.nudg.DeletedNudg
import chris.did.presentation.nudg.Nudg
import chris.did.presentation.nudg.UserNudg
import chris.did.presentation.nudg.section.SystemTagSection
import java.util.*

/**
 * NudgFactory
 */
class NudgFactory(private val sectionFactory: SectionParser) : NudgCreator {

    override fun createNewNudg(input: String): Nudg {
        val sections = sectionFactory.parseSections(input)
        if (!input.contains("#")) {
            sections.add(SystemTagSection(UUID.randomUUID(), SystemTags.NO_TAG))
        }
        return UserNudg(UUID.randomUUID(), input, "", sections.toList())
    }

    override fun convertToNudgData(nudg: Nudg): RealmNudgData {
        val isDeleted = nudg is DeletedNudg
        val sectionData = sectionFactory.convertAllToTagData(nudg.sections)
        return RealmNudgData(nudg.id.toString(), nudg.text, nudg.notes, sectionData, isDeleted)
    }

    override fun convertToNudg(data: RealmNudgData): Nudg {
        val id = UUID.fromString(data.id)
        val convertedSections = sectionFactory.convertAllToTag(data.sections)
        return when {
            data.deleted -> DeletedNudg(id, data.text, data.notes, convertedSections)
            else         -> UserNudg(id, data.text, data.notes, convertedSections)
        }
    }
}
