package chris.did.presentation.nudgfactory

import chris.did.data.room.nudgdata.RealmNudgData
import chris.did.presentation.nudg.Nudg

/**
 * NudgCreator
 */
interface NudgCreator {

    fun createNewNudg(input: String): Nudg
    fun convertToNudgData(nudg: Nudg): RealmNudgData
    fun convertToNudg(data: RealmNudgData): Nudg
}