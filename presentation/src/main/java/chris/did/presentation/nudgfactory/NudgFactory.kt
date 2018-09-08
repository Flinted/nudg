package chris.did.presentation.nudgfactory

import chris.did.presentation.nudg.Nudg
import chris.did.presentation.nudg.UserNudg

/**
 * NudgFactory
 */
class NudgFactory(private val tagFactory: TagParser) : NudgCreator {

    override fun createNewNudg(input: String): Nudg {
        val tags = tagFactory.parseTags(input)
        val nudg = UserNudg(input, tags)
        return nudg
    }
}
