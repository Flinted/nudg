package chris.did.data.nudgservice

import chris.did.data.repository.Repository
import chris.did.data.room.nudgdata.RoomNudgData

/**
 * NudgService
 */
class NudgService(private val repository: Repository) : NudgServicable {

    override fun getNudgs() = repository.getNudgs()
    override fun postNudg(nudgData: RoomNudgData) = repository.postNudg(nudgData)
}
