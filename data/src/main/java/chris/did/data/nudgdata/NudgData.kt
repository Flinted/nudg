package chris.did.data.nudgdata

import chris.did.data.tagdata.SectionData

/**
 * NudgData
 */
interface NudgData {
    val id: String
    val tags: List<SectionData>
    val deleted: Boolean
}