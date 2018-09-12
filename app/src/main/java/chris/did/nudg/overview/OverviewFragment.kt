package chris.did.nudg.overview

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import chris.did.nudg.R
import chris.did.nudg.base.BaseActivity
import chris.did.nudg.base.BaseFragment
import chris.did.nudg.databinding.FragmentOverviewBinding
import chris.did.nudg.injection.viewmodels.ViewModelFactory
import chris.did.nudg.nudglist.NudgListAdapter
import chris.did.nudg.nudglist.SwipeDetector
import chris.did.presentation.nudgviewmodel.NudgViewModel
import javax.inject.Inject

/**
 * OverviewFragment
 */
class OverviewFragment : BaseFragment(), OverviewViewModelListener, OverviewBackPressListener {

    companion object {
        fun newInstance(): OverviewFragment {
            return OverviewFragment()
        }
    }

    @Inject
    lateinit var factory: ViewModelFactory<OverviewViewModel>
    private lateinit var binding: FragmentOverviewBinding
    private lateinit var viewModel: OverviewViewModellable
    private val originalConstraint = ConstraintSet()
    private val inputConstraint = ConstraintSet()
    private var currentConstraintSet = originalConstraint

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getViewModelComponent().inject(this)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_overview, container, false);
        viewModel = ViewModelProviders.of(this, factory).get(OverviewViewModel::class.java)
        binding.viewModel = viewModel
        originalConstraint.clone(binding.overviewConstraint)
        inputConstraint.clone(requireContext(), R.layout.fragment_overview_input)
        viewModel.setListener(this)
        viewModel.getNudgs()
        (activity as BaseActivity).backPressListener = this
        return binding.root
    }

    override fun onNudgInputBegun() {
    }

    override fun onNudgsRetrieved(nudgs: List<NudgViewModel>) {
        val adapter = NudgListAdapter(nudgs)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(requireContext())
        val swipeDetector = SwipeDetector()
        ItemTouchHelper(swipeDetector).attachToRecyclerView(binding.overviewNudgList)
        binding.overviewNudgList.layoutManager = layoutManager
        binding.overviewNudgList.adapter = adapter
    }

    override fun onNoNudgsFound() {
        Toast.makeText(requireContext(), "NO NUDGS STORED", Toast.LENGTH_LONG).show()
    }

    override fun onNudgSearchValuesChanged(value: String) {
        (binding.overviewNudgList.adapter as NudgListAdapter).filter.filter(value)
    }

    //BackPressListener

    override fun handleBackPressEvent(): Boolean {
        if (currentConstraintSet == originalConstraint) {
            return false
        }
        originalConstraint.applyTo(binding.overviewConstraint)
        currentConstraintSet = originalConstraint
        return true
    }
}
