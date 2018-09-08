package chris.did.presentation.overview

import chris.did.presentation.base.BasePresentable

/**
 * OverviewPresentable
 */
interface OverviewPresentable: BasePresentable<OverviewPresenterListener> {
    fun getNudgs()
}
