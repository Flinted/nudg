package chris.did.data.room.sectiondata

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

/**
 * RealmSectionData
 */
@RealmClass
open class RealmSectionData() : RealmModel {
    @PrimaryKey
    lateinit var id: String
    lateinit var tag: String
    lateinit var type: String

    constructor(id: String, tag: String, type: String) : this() {
        this.id = id
        this.tag = tag
        this.type = type
    }
}