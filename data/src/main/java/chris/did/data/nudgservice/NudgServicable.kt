package chris.did.data.nudgservice

import chris.did.data.room.nudgdata.RoomNudgData

/**
 * NudgServicable
 */

interface NudgServicable {
    fun getNudgs(): List<RoomNudgData>
    fun postNudg(nudgData: RoomNudgData)
}
