package chris.did.nudg.nudginput

import android.databinding.BindingAdapter
import android.widget.EditText
import chris.did.nudg.R

/**
 * NudgInputBindingAdapter
 */
object NudgInputBindingAdapter {

    @JvmStatic
    @BindingAdapter("nudgInput:validWhen")
    fun setInputErrorState(view: EditText, valid: Boolean) {
        if (!valid) {
            view.error = view.context.getString(R.string.nudg_input_error)
            return
        }
        view.error = null
    }
}
