package chris.did.data.room.nudgdata

import chris.did.data.room.sectiondata.RealmSectionData
import io.realm.RealmList
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

/**
 * RealmNudgData
 */
@RealmClass
open class RealmNudgData() : RealmModel {
    @PrimaryKey
    lateinit var id: String
    lateinit var text: String
    lateinit var notes: String
    lateinit var sections: RealmList<RealmSectionData>
    var deleted: Boolean = true

    constructor(
        id: String,
        text: String,
        notes: String,
        sections: RealmList<RealmSectionData>,
        deleted: Boolean
    ) : this() {
        this.id = id
        this.text = text
        this.notes = notes
        this.sections = sections
        this.deleted = deleted
    }
}
