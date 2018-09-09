package chris.did.nudg.overview

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import chris.did.nudg.R
import chris.did.nudg.base.BaseFragment
import chris.did.nudg.databinding.FragmentOverviewBinding
import chris.did.nudg.injection.viewmodels.ViewModelFactory
import javax.inject.Inject

/**
 * OverviewFragment
 */
class OverviewFragment : BaseFragment() {

    companion object {
        fun newInstance(): OverviewFragment {
            return OverviewFragment()
        }
    }

    @Inject
    lateinit var factory: ViewModelFactory<OverviewViewModel>

    private lateinit var binding: FragmentOverviewBinding
    private lateinit var viewModel: OverviewViewModellable

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getViewModelComponent().inject(this)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_overview, container, false);
        viewModel = ViewModelProviders.of(this, factory).get(OverviewViewModel::class.java)
        binding.viewModel = viewModel
        return binding.root
    }
}
