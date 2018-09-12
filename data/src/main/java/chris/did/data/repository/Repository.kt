package chris.did.data.repository

import chris.did.data.room.nudgdata.RealmNudgData
import io.realm.Realm

/**
 * Repository
 */
interface Repository {
    fun postNudg(nudgData: RealmNudgData, realm: Realm)

    fun getNudgs(): List<RealmNudgData>
    fun getNudgById(id: String): RealmNudgData?
    fun getNudgsByIds(vararg ids: String): List<RealmNudgData>

    fun patchNudg(nudgPatch: String)

    fun deleteNudgById(id: String)
    fun deleteNudgsByIds(vararg ids: String)
}