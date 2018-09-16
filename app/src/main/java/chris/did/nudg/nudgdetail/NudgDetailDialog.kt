package chris.did.nudg.nudgdetail

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import chris.did.nudg.R
import chris.did.nudg.base.BaseDialog
import chris.did.nudg.databinding.DialogNudgDetailBinding
import chris.did.nudg.injection.viewmodels.ViewModelFactory
import java.util.*
import javax.inject.Inject

/**
 * NudgDetailDialog
 */
private const val ID_KEY = "id"

class NudgDetailDialog : BaseDialog() {

    companion object {
        fun createInstance(id: UUID): NudgDetailDialog {
            val bundle = Bundle()
            bundle.putString(ID_KEY, id.toString())
            val fragment = NudgDetailDialog()
            fragment.arguments = bundle
            return fragment
        }
    }

    @Inject
    lateinit var factory: ViewModelFactory<NudgDetailViewModel>
    private lateinit var binding: DialogNudgDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getViewModelComponent().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val id = arguments?.getString(ID_KEY)
            ?: throw Exception("Cannot create detail fragment without id")
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_nudg_detail, container, false)
        val viewModel = ViewModelProviders.of(this, factory).get(NudgDetailViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.getNudgForId(id)
        return binding.root
    }
}
