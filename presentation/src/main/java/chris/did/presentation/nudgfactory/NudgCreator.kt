package chris.did.presentation.nudgfactory

import chris.did.presentation.nudg.Nudg

/**
 * NudgCreator
 */
interface NudgCreator {

    fun createNewNudg(input: String): Nudg
}