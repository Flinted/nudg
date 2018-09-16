package chris.did.nudg.nudgdetail

import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import chris.did.nudg.base.BaseApplication
import chris.did.nudg.base.BaseViewModel
import chris.did.presentation.nudgdetail.NudgDetailPresentable
import chris.did.presentation.nudgdetail.NudgDetailPresenterListener
import chris.did.presentation.nudgviewmodel.NudgViewModel
import chris.did.presentation.nudgviewmodel.sectionviewmodel.SectionViewModel
import java.util.*

/**
 * NudgDetailViewModel
 */
class NudgDetailViewModel(
    application: BaseApplication,
    private val presenter: NudgDetailPresentable
) : BaseViewModel(application),
    NudgDetailViewModellable,
    NudgDetailPresenterListener {

    override val nudgText = ObservableField<String>()
    override val tags = ObservableArrayList<SectionViewModel>()
    override val notes = ObservableField<String>()
    override val time = ObservableField<String>()
    val image = ObservableField<String>()

    init {
        presenter.setListener(this)
    }

    fun getNudgForId(id: String) {
        presenter.getNudgForId(UUID.fromString(id))
    }

    // NudgDetailPresenterListener
    override fun onGetNudgFailure(exception: Exception) {

    }

    override fun onGetNudgSuccess(nudgViewModel: NudgViewModel) {
        nudgText.set(nudgViewModel.getBuiltText())
        notes.set(nudgViewModel.getNotes())
        time.set(nudgViewModel.getSectionsText())
    }
}
