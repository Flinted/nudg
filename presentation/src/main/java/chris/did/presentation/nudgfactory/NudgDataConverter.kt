package chris.did.presentation.nudgfactory

import chris.did.data.room.nudgdata.RoomNudgData
import chris.did.presentation.nudg.Nudg

/**
 * NudgDataConverter
 */
interface NudgDataConverter {

    fun convertToNudgData(nudg: Nudg): RoomNudgData
    fun convertToNudg(data: RoomNudgData): Nudg
}