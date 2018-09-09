package chris.did.data.repository

import chris.did.data.nudgdata.NudgData
import chris.did.data.nudgdata.RealmNudgData
import chris.did.data.tagdata.RealmSectionData
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
                listOf(
                    RealmSectionData(UUID.randomUUID().toString(), "Testing ", "STRING"),
                    RealmSectionData(UUID.randomUUID().toString(), "#tags", "USER"),
                    RealmSectionData(UUID.randomUUID().toString(), " as well as ", "STRING"),
                    RealmSectionData(UUID.randomUUID().toString(), "#2013/10/14", "DATE"),
                    RealmSectionData(UUID.randomUUID().toString(), " ", "STRING"),
                    RealmSectionData(UUID.randomUUID().toString(), "#MON", "SYSTEM"),
                    RealmSectionData(
                        UUID.randomUUID().toString(),
                        ", It's actually worked ",
                        "STRING"
                    ),
                    RealmSectionData(UUID.randomUUID().toString(), "#WOOO!", "USER")
                ),
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
