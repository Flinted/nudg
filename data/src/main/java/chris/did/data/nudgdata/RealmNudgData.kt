package chris.did.data.nudgdata

import chris.did.data.tagdata.SectionData
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey

/**
 * RealmNudgData
 */
class RealmNudgData(
    @PrimaryKey override val id: String,
    override val tags: List<SectionData>,
    override val deleted: Boolean
) : RealmModel, NudgData

