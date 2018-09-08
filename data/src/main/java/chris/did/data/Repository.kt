package chris.did.data

/**
 * Repository
 */
interface Repository {
    fun postNewNudg()

    fun getNudgs(): List<RealmNudgData>
    fun getNudgById(id: String): RealmNudgData
    fun getNudgsByIds(vararg ids: String): List<RealmNudgData>

    fun patchNudg(nudgPatch: String)

    fun deleteNudgById(id: String)
    fun deleteNudgsByIds(vararg ids: String)
}