package chris.did.presentation.nudgfactory

import chris.did.data.room.sectiondata.RoomSectionData
import chris.did.presentation.nudg.section.Section
import java.util.*

/**
 * SectionDataConverter
 */
interface SectionDataConverter {

    fun convertToTagData(tag: Section): RoomSectionData
    fun convertAllToTagData(tags: List<Section>): ArrayList<RoomSectionData>
    fun convertToTag(data: RoomSectionData): Section
    fun convertAllToTag(data: ArrayList<RoomSectionData>): List<Section>
}
