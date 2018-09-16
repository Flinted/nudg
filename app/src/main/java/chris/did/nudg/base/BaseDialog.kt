package chris.did.nudg.base

import android.app.Activity
import android.support.annotation.UiThread
import android.support.v4.app.DialogFragment
import chris.did.nudg.error.ErrorDisplayable
import chris.did.nudg.injection.application.ApplicationComponent
import chris.did.nudg.injection.viewmodels.ViewModelComponent

/**
 * BaseDialog
 */

abstract class BaseDialog : DialogFragment(), ErrorDisplayable {

    @UiThread
    protected fun getApplicationComponent(): ApplicationComponent {
        return (activity?.application as BaseApplication)
            .getApplicationComponent()
    }

    @UiThread
    protected fun getViewModelComponent(): ViewModelComponent {
        return (activity?.application as BaseApplication)
            .getViewModelComponent(activity as Activity)
    }
}