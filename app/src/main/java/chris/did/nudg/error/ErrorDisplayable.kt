package chris.did.nudg.error

import android.content.Context
import android.widget.Toast
import chris.did.nudg.R

/**
 * ErrorDisplayable
 */
interface ErrorDisplayable {

    fun showErrorToast(
        context: Context,
        stringId: Int?,
        duration: Int = Toast.LENGTH_SHORT
    ) {
        val errorStringId = stringId ?: R.string.error_default_message
        Toast.makeText(context, errorStringId, duration).show()
    }
}