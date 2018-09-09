package chris.did.presentation.nudgfactory

import chris.did.data.nudgdata.NudgData
import chris.did.data.nudgdata.RealmNudgData
import chris.did.presentation.nudg.DeletedNudg
import chris.did.presentation.nudg.Nudg
import chris.did.presentation.nudg.UserNudg
import java.util.*

/**
 * NudgFactory
 */
class NudgFactory(private val sectionFactory: SectionParser) : NudgCreator, NudgDataConverter {

    override fun createNewNudg(input: String): Nudg {
        val sectionedString = StringParser.parseStringIntoSections(input)
        val sections = sectionFactory.parseSections(sectionedString)
        return UserNudg(UUID.randomUUID(), sections)
    }

    override fun convertToNudgData(nudg: Nudg): NudgData {
        val isDeleted = nudg is DeletedNudg
        val sectionData =
            (sectionFactory as SectionDataConverter).convertAllToTagData(nudg.sections)
        return RealmNudgData(
            nudg.id.toString(),
            sectionData,
            isDeleted
        )
    }

    override fun convertToNudg(data: NudgData): Nudg {
        val id = UUID.fromString(data.id)
        val sections = (sectionFactory as SectionDataConverter).convertAllToTag(data.tags)
        return when {
            data.deleted -> DeletedNudg(id, sections)
            else         -> UserNudg(id, sections)
        }
    }
}
