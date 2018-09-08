package chris.did.data.nudgdata

import chris.did.data.tagdata.TagData

/**
 * NudgData
 */
interface NudgData {
    val id: String
    val text: String
    val tags: List<TagData>
    val deleted: Boolean
}