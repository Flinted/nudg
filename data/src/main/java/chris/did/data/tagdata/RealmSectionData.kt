package chris.did.data.tagdata

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey

/**
 * RealmSectionData
 */
class RealmSectionData(
    @PrimaryKey override val id: String,
    override val tag: String,
    override val type: String
) : RealmModel, SectionData