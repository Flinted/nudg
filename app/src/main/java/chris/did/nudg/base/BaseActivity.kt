package chris.did.nudg.base

import android.support.annotation.UiThread
import android.support.v7.app.AppCompatActivity
import chris.did.nudg.error.ErrorDisplayable
import chris.did.nudg.injection.application.ApplicationComponent
import chris.did.nudg.injection.viewmodels.ViewModelComponent

/**
 * BaseActivity
 */
abstract class BaseActivity : AppCompatActivity(), ErrorDisplayable {

    @UiThread
    protected fun getApplicationComponent(): ApplicationComponent {
        return (application as BaseApplication)
            .getApplicationComponent()
    }

    @UiThread
    protected fun getViewModelComponent(): ViewModelComponent {
        return (application as BaseApplication).getViewModelComponent(this)
    }
}