package chris.did.nudg.overview

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import chris.did.nudg.R
import chris.did.nudg.base.BaseActivity
import chris.did.nudg.databinding.ActivityOverviewBinding
import chris.did.nudg.injection.viewmodels.ViewModelFactory
import javax.inject.Inject

/**
 * OverviewActivity
 */

class OverviewActivity: BaseActivity() {

    @Inject
    lateinit var factory: ViewModelFactory<OverviewViewModel>

    private lateinit var binding: ActivityOverviewBinding
    private lateinit var viewModel: OverviewViewModellable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getViewModelComponent().inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_overview)
        viewModel = ViewModelProviders.of(this, factory).get(OverviewViewModel::class.java)
        binding.viewModel = viewModel
    }
}
