package chris.did.nudg.extensions

import android.content.Context
import android.os.IBinder
import android.view.inputmethod.InputMethodManager
import chris.did.nudg.base.BaseActivity

/**
 * `Activity Extensions`
 */

fun BaseActivity.showKeyboard() {
    val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
}

fun BaseActivity.hideKeyboard(windowToken: IBinder) {
    val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}