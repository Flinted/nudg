package chris.did.data.nudgservice

import chris.did.data.RealmNudgData

/**
 * NudgServicable
 */

interface NudgServicable {
    fun getNudgs(): List<RealmNudgData>
}
