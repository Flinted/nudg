package chris.did.presentation.nudgviewmodelfactory

import chris.did.presentation.nudg.DeletedNudg
import chris.did.presentation.nudg.Nudg
import chris.did.presentation.nudgviewmodel.DeletedNudgViewModel
import chris.did.presentation.nudgviewmodel.NudgViewModel
import chris.did.presentation.nudgviewmodel.UserNudgViewModel

/**
 * NudgViewModelFactory
 */
class NudgViewModelFactory(private val tagViewModelFactory: SectionViewModelCreator) : NudgViewModelCreator {

    override fun create(nudgs: List<Nudg>): List<NudgViewModel> {
        return nudgs.map { nudg ->
            val tags = tagViewModelFactory.create(nudg.sections)
            when (nudg) {
                is DeletedNudg -> DeletedNudgViewModel(nudg, tags)
                else           -> UserNudgViewModel(nudg, tags)
            }
        }
    }
}