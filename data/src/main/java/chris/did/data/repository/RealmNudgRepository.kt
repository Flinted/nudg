package chris.did.data.repository

import chris.did.data.room.nudgdata.RealmNudgData
import io.realm.Realm
import java.util.*

/**
 * RealmNudgRepository
 */
class RealmNudgRepository() : Repository {

    override fun postNudg(nudgData: RealmNudgData, realm: Realm) {
        realm.executeTransaction {
            realm.copyToRealmOrUpdate(nudgData)
        }
    }

    override fun getNudgs(): List<RealmNudgData> {
        val realm = Realm.getDefaultInstance()
        val results = realm.where(RealmNudgData::class.java).findAll()
        val copyResults = realm.copyFromRealm(results)
        realm.close()
        return copyResults
    }

    override fun getNudgById(id: UUID): RealmNudgData? {
        val realm = Realm.getDefaultInstance()
        return realm
            .where(RealmNudgData::class.java)
            .equalTo("id", id.toString())
            .findFirst() ?: return null
    }

    override fun getNudgsByIds(vararg ids: UUID): List<RealmNudgData> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun patchNudg(nudgPatch: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteNudgById(id: UUID) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteNudgsByIds(vararg ids: UUID) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
