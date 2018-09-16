package chris.did.data.nudgservice

import chris.did.data.room.nudgdata.RealmNudgData
import io.realm.Realm
import java.util.*

/**
 * NudgServicable
 */

interface NudgServicable {
    fun getNudgs(): List<RealmNudgData>
    fun postNudg(
        nudgData: RealmNudgData,
        defaultInstance: Realm
    )
    fun getNudgById(id: UUID): RealmNudgData?
}
