package chris.did.data.repository

import chris.did.data.room.nudgdata.RoomNudgData

/**
 * Repository
 */
interface Repository {
    fun postNudg(nudgData: RoomNudgData)

    fun getNudgs(): List<RoomNudgData>
    fun getNudgById(id: String): RoomNudgData
    fun getNudgsByIds(vararg ids: String): List<RoomNudgData>

    fun patchNudg(nudgPatch: String)

    fun deleteNudgById(id: String)
    fun deleteNudgsByIds(vararg ids: String)
}