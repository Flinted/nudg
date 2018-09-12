package chris.did.data.nudgservice

import chris.did.data.repository.Repository
import chris.did.data.room.nudgdata.RealmNudgData
import io.realm.Realm

/**
 * NudgService
 */
class NudgService(private val repository: Repository) : NudgServicable {

    override fun getNudgs() = repository.getNudgs()
    override fun postNudg(
        nudgData: RealmNudgData,
        defaultInstance: Realm
    ) = repository.postNudg(nudgData, defaultInstance)
}
