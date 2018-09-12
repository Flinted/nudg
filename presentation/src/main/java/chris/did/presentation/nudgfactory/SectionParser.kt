package chris.did.presentation.nudgfactory

import chris.did.data.room.sectiondata.RealmSectionData
import chris.did.presentation.nudg.section.Section
import io.realm.RealmList

/**
 * TagExtractor
 */
interface SectionParser {

    fun parseSections(input: String): MutableList<Section>
    fun convertToTagData(tag: Section): RealmSectionData
    fun convertAllToTagData(tags: List<Section>): RealmList<RealmSectionData>
    fun convertToTag(data: RealmSectionData): Section
    fun convertAllToTag(data: List<RealmSectionData>): List<Section>
}
