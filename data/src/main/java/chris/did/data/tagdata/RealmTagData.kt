package chris.did.data.tagdata

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey

/**
 * RealmTagData
 */
class RealmTagData(
    @PrimaryKey override val id: String,
    override val tag: String,
    override val type: String
) : RealmModel, TagData