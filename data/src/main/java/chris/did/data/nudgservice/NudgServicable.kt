package chris.did.data.nudgservice

import chris.did.data.room.nudgdata.RealmNudgData
import io.realm.Realm

/**
 * NudgServicable
 */

interface NudgServicable {
    fun getNudgs(): List<RealmNudgData>
    fun postNudg(
        nudgData: RealmNudgData,
        defaultInstance: Realm
    )
}
