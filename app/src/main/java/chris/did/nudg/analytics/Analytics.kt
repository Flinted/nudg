package chris.did.nudg.analytics

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import chris.did.nudg.BuildConfig
import com.crashlytics.android.Crashlytics
import java.text.SimpleDateFormat
import java.util.*

/**
 * Analytics
 */

private const val BRAND = "Device Brand"
private const val MODEL = "Device Model"
private const val VERSION = "Android Version"
private const val ORIENTATION = "In Landscape"
private const val DEVICE_TIME_UTC = "Device Time(UTC)"

internal object Analytics {

    internal fun setInitialValues(context: Context) {
        if (BuildConfig.DEBUG) {
            return
        }
        Crashlytics.setString(BRAND, Build.BRAND)
        Crashlytics.setString(MODEL, Build.MODEL)
        Crashlytics.setString(VERSION, Build.VERSION.RELEASE)
    }

    internal fun updateValuesForCurrentState(context: Context) {
        if (BuildConfig.DEBUG) {
            return
        }
        setTimeStamp()
        setCurrentOrientationValue(context)
    }

    private fun setTimeStamp() {
        val timeNow = Date()
        val timePattern = "dd/MM/yyyy HH:mm:ss"
        val dateFormat = SimpleDateFormat(timePattern)
        val formattedTime = dateFormat.format(timeNow)
        Crashlytics.setString(DEVICE_TIME_UTC, "$formattedTime UTC")
    }

    private fun setCurrentOrientationValue(context: Context) {
        val orientation = context.resources.configuration.orientation
        val isLandscape = orientation == Configuration.ORIENTATION_LANDSCAPE
        Crashlytics.setBool(ORIENTATION, isLandscape)
    }
}