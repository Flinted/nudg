package chris.did.data.repository

import chris.did.data.room.nudgdata.RealmNudgData
import io.realm.Realm

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

    override fun getNudgById(id: String): RealmNudgData? {
        val realm = Realm.getDefaultInstance()
        return realm
            .where(RealmNudgData::class.java)
            .equalTo("id", id)
            .findFirst() ?: return null
    }

    override fun getNudgsByIds(vararg ids: String): List<RealmNudgData> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun patchNudg(nudgPatch: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteNudgById(id: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteNudgsByIds(vararg ids: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
