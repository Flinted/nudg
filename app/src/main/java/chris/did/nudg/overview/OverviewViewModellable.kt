package chris.did.nudg.overview

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.view.View

/**
 * OverviewViewModellable
 */

interface OverviewViewModellable {

    val inputValid: ObservableBoolean
    val nudgInput: ObservableField<String>
    fun setListener(listener: OverviewViewModelListener)
    fun nudgInputChanged(input: CharSequence)
    fun getNudgs()
    fun onSaveNudgTapped(view: View)
}
