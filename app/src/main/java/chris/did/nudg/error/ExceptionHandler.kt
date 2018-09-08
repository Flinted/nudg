package chris.did.nudg.error

import android.content.Context
import chris.did.nudg.BuildConfig
import chris.did.nudg.analytics.Analytics
import com.crashlytics.android.Crashlytics

/**
 * ExceptionHandler
 */
internal object ExceptionHandler {

    internal fun logException(context: Context, exception: Exception) {
        if (BuildConfig.DEBUG) {
            return
        }
        Analytics.updateValuesForCurrentState(context)
        Crashlytics.logException(exception)
    }
}