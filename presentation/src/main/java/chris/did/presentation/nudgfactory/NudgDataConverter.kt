package chris.did.presentation.nudgfactory

import chris.did.data.nudgdata.NudgData
import chris.did.presentation.nudg.Nudg

/**
 * NudgDataConverter
 */
interface NudgDataConverter {

    fun convertToNudgData(nudg: Nudg): NudgData
    fun convertToNudg(data: NudgData): Nudg
}