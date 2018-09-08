package chris.did.data.nudgservice

import chris.did.data.nudgdata.NudgData

/**
 * NudgServicable
 */

interface NudgServicable {
    fun getNudgs(): List<NudgData>
    fun postNudg(nudgData: NudgData)
}
