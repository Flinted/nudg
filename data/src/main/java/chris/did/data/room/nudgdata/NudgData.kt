package chris.did.data.room.nudgdata

import chris.did.data.room.sectiondata.SectionData

/**
 * NudgData
 */
interface NudgData {
    val id: String
    val tags: List<SectionData>
    val deleted: Boolean
}