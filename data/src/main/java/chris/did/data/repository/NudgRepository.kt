package chris.did.data.repository

import chris.did.data.nudgdata.NudgData
import chris.did.data.nudgdata.RealmNudgData
import java.util.*

/**
 * NudgRepository
 */
class NudgRepository : Repository {

    override fun postNudg(nudgData: NudgData) {
    }

    override fun getNudgs(): List<NudgData> {
        return listOf(
            RealmNudgData(
                UUID.randomUUID().toString(),
                "IT WORKS",
                listOf(),
                false
            )
        )
    }

    override fun getNudgById(id: String): NudgData {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getNudgsByIds(vararg ids: String): List<NudgData> {
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
