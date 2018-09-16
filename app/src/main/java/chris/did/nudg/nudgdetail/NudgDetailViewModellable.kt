package chris.did.nudg.nudgdetail

import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import chris.did.presentation.nudgviewmodel.sectionviewmodel.SectionViewModel

/**
 * NudgDetailViewModellable
 */
interface NudgDetailViewModellable {

    val nudgText: ObservableField<String>
    val notes: ObservableField<String>
    val tags: ObservableArrayList<SectionViewModel>
    val time: ObservableField<String>
}