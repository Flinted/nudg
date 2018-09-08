package chris.did.data.nudgservice

import chris.did.data.nudgdata.NudgData
import chris.did.data.repository.Repository

/**
 * NudgService
 */
class NudgService(private val repository: Repository) : NudgServicable {

    override fun getNudgs() = repository.getNudgs()

    override fun postNudg(nudgData: NudgData) = repository.postNudg(nudgData)
}
