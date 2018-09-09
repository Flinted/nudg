package chris.did.data.repository

import android.content.Context
import chris.did.data.room.NudgDatabase
import chris.did.data.room.nudgdata.RoomNudgData

/**
 * NudgRepository
 */
class NudgRepository(context: Context) : Repository {

    private val database = NudgDatabase.getInstance(context)

    override fun postNudg(nudgData: RoomNudgData) {
        val roomNudgData = nudgData as? RoomNudgData ?: return
        database?.nudgDao()?.insert(roomNudgData)
    }

    override fun getNudgs(): List<RoomNudgData> {
        return database?.nudgDao()?.getAll() ?: listOf()
//        return listOf(
//            RoomNudgData(
//                UUID.randomUUID().toString(),
//                listOf(
//                    RoomSectionData(UUID.randomUUID().toString(), "Testing ", "STRING"),
//                    RoomSectionData(UUID.randomUUID().toString(), "#tags", "USER"),
//                    RoomSectionData(UUID.randomUUID().toString(), " as well as ", "STRING"),
//                    RoomSectionData(UUID.randomUUID().toString(), "#2013/10/14", "DATE"),
//                    RoomSectionData(UUID.randomUUID().toString(), " ", "STRING"),
//                    RoomSectionData(UUID.randomUUID().toString(), "#MON", "SYSTEM"),
//                    RoomSectionData(
//                        UUID.randomUUID().toString(),
//                        ", It's actually worked ",
//                        "STRING"
//                    ),
//                    RoomSectionData(UUID.randomUUID().toString(), "#WOOO!", "USER")
//                ),
//                false
//            )
//        )
    }

    override fun getNudgById(id: String): RoomNudgData {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getNudgsByIds(vararg ids: String): List<RoomNudgData> {
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
