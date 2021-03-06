package chris.did.nudg.overview

import android.content.Context
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.view.View
import android.widget.Toast
import chris.did.nudg.base.BaseApplication
import chris.did.nudg.base.BaseViewModel
import chris.did.presentation.nudgfactory.StringParser
import chris.did.presentation.nudgviewmodel.NudgViewModel
import chris.did.presentation.overview.OverviewPresentable
import chris.did.presentation.overview.OverviewPresenterListener

/**
 * OverviewViewModel
 */
class OverviewViewModel(
    application: BaseApplication,
    private val presenter: OverviewPresentable
) : BaseViewModel(application), OverviewViewModellable, OverviewPresenterListener {

    override var nudgInput = ObservableField<String>("")
    override val inputValid = ObservableBoolean(true)
    private var listener: OverviewViewModelListener? = null

    init {
        this.presenter.setListener(this)
    }

    override fun setListener(listener: OverviewViewModelListener) {
        this.listener = listener
    }

    override fun nudgInputChanged(input: CharSequence) {
        if (input.toString() == nudgInput.get()) {
            return
        }
        val tags = StringParser.parseStringIntoSections(input.toString())
        if (tags.isNotEmpty()) {
            listener?.onNudgSearchValuesChanged(tags.first())
        }
        nudgInput.set(input.toString())
    }

    override fun onSaveNudgTapped(view: View) = presenter.saveNudg(nudgInput.get())

    override fun didFindInvalidNudgInput() {
        inputValid.set(false)
    }

    override fun didFindValidNudgInput() {
        inputValid.set(true)
    }

    override fun getNudgs() {
        presenter.getNudgs()
    }

    override fun didGetNudgs(nudgs: List<NudgViewModel>) {
        if (nudgs.isEmpty()) {
            listener?.onNoNudgsFound()
            return
        }
        listener?.onNudgsRetrieved(nudgs)
    }

    override fun didFailToGetNudgs(exception: Exception) {
    }

    override fun didSaveNudg() {
        nudgInput.set("")
        Toast.makeText(getApplication() as Context, "Nudg Saved :-)", Toast.LENGTH_LONG).show()
        getNudgs()
    }

    override fun didFailToSaveNudg() {
    }

    override fun onNudgInputTapped(view: View) {
        listener?.onNudgInputBegun()
    }

    override fun onNudgInputLongPressed(view: View) {
        val currentText = nudgInput.get()
        nudgInput.set("$currentText#")
    }
}
