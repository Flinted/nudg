package chris.did.nudg.overview

import chris.did.presentation.nudgviewmodel.NudgViewModel

/**
 * OverviewViewModelListener
 */
interface OverviewViewModelListener {

    fun onNudgsRetrieved(nudgs: List<NudgViewModel>)
    fun onNudgSearchValuesChanged(value: String)
    fun onNoNudgsFound()
    fun onNudgInputBegun()
}
