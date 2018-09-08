package chris.did.data

import java.util.*

/**
 * RealmNudgData
 */
class RealmNudgData(
    override val id: String,
    override val text: String,
    override val tags: List<TagData>,
    override val deleted: Boolean
) : NudgData

