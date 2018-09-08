package chris.did.data.nudgservice

import chris.did.data.Repository

/**
 * NudgService
 */
class NudgService(private val repository: Repository) : NudgServicable {

    override fun getNudgs() = repository.getNudgs()
}