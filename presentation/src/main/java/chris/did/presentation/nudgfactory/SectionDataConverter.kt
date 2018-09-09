package chris.did.presentation.nudgfactory

import chris.did.data.tagdata.SectionData
import chris.did.presentation.nudg.section.Section

/**
 * SectionDataConverter
 */
interface SectionDataConverter {

    fun convertToTagData(tag: Section): SectionData
    fun convertAllToTagData(tags: List<Section>): List<SectionData>
    fun convertToTag(data: SectionData): Section
    fun convertAllToTag(data: List<SectionData>): List<Section>
}
