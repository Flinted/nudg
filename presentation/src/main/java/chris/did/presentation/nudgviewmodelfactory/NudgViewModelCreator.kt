package chris.did.presentation.nudgviewmodelfactory

import chris.did.presentation.nudg.Nudg
import chris.did.presentation.nudgviewmodel.NudgViewModel

/**
 * NudgViewModelCreator
 */
interface NudgViewModelCreator {

    fun create(nudg: Nudg): NudgViewModel
    fun create(nudgs: List<Nudg>): List<NudgViewModel>
}
