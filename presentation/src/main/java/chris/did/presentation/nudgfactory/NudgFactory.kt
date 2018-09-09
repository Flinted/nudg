package chris.did.presentation.nudgfactory

import chris.did.data.room.nudgdata.RoomNudgData
import chris.did.presentation.nudg.DeletedNudg
import chris.did.presentation.nudg.Nudg
import chris.did.presentation.nudg.UserNudg
import chris.did.presentation.nudg.section.SystemTagSection
import java.util.*

/**
 * NudgFactory
 */
class NudgFactory(private val sectionFactory: SectionParser) : NudgCreator, NudgDataConverter {

    override fun createNewNudg(input: String): Nudg {
        val sectionedString = StringParser.parseStringIntoSections(input)
        val sections = sectionFactory.parseSections(sectionedString)
        if (!input.contains("#")) {
             sections.add(SystemTagSection(UUID.randomUUID(), " #NoTag"))
        }
        return UserNudg(UUID.randomUUID(), sections.toList())
    }

    override fun convertToNudgData(nudg: Nudg): RoomNudgData {
        val isDeleted = nudg is DeletedNudg
        val sectionData =
            (sectionFactory as SectionDataConverter).convertAllToTagData(nudg.sections)
        return RoomNudgData(
            nudg.id.toString(),
            sectionData,
            isDeleted
        )
    }

    override fun convertToNudg(data: RoomNudgData): Nudg {
        val id = UUID.fromString(data.id)
        val sections = (sectionFactory as SectionDataConverter).convertAllToTag(data.sections)
        return when {
            data.deleted -> DeletedNudg(id, sections)
            else         -> UserNudg(id, sections)
        }
    }
}
