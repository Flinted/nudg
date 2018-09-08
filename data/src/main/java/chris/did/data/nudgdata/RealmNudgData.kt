package chris.did.data.nudgdata

import chris.did.data.tagdata.TagData

/**
 * RealmNudgData
 */
class RealmNudgData(
    override val id: String,
    override val text: String,
    override val tags: List<TagData>,
    override val deleted: Boolean
) : NudgData

