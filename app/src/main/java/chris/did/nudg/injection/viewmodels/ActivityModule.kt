package chris.did.nudg.injection.viewmodels

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * ActivityModule
 */
@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    fun context(): Context = activity

    @Provides
    fun activity(): Activity = activity
}
