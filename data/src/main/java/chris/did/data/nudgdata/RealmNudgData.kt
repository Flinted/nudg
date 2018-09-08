package chris.did.data.nudgdata

import chris.did.data.tagdata.TagData
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey

/**
 * RealmNudgData
 */
class RealmNudgData(
    @PrimaryKey override val id: String,
    override val text: String,
    override val tags: List<TagData>,
    override val deleted: Boolean
) : RealmModel, NudgData

