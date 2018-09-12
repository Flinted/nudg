package chris.did.nudg.overview

import android.os.Bundle
import chris.did.nudg.R
import chris.did.nudg.base.BaseActivity

/**
 * OverviewActivity
 */

interface OverviewBackPressListener {
    fun handleBackPressEvent(): Boolean
}

class OverviewActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getViewModelComponent().inject(this)
        setContentView(R.layout.activity_landing)
        val overviewFragment = OverviewFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.activity_landing_content, overviewFragment)
            .commit()
    }
}
