package chris.did.data.repository

import chris.did.data.nudgdata.NudgData

/**
 * Repository
 */
interface Repository {
    fun postNudg(nudgData: NudgData)

    fun getNudgs(): List<NudgData>
    fun getNudgById(id: String): NudgData
    fun getNudgsByIds(vararg ids: String): List<NudgData>

    fun patchNudg(nudgPatch: String)

    fun deleteNudgById(id: String)
    fun deleteNudgsByIds(vararg ids: String)
}