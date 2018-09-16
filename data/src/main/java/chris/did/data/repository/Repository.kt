package chris.did.data.repository

import chris.did.data.room.nudgdata.RealmNudgData
import io.realm.Realm
import java.util.*

/**
 * Repository
 */
interface Repository {
    fun postNudg(nudgData: RealmNudgData, realm: Realm)

    fun getNudgs(): List<RealmNudgData>
    fun getNudgById(id: UUID): RealmNudgData?
    fun getNudgsByIds(vararg ids: UUID): List<RealmNudgData>

    fun patchNudg(nudgPatch: String)

    fun deleteNudgById(id: UUID)
    fun deleteNudgsByIds(vararg ids: UUID)
}