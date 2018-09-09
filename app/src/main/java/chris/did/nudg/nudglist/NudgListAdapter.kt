package chris.did.nudg.nudglist

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import chris.did.nudg.R
import chris.did.nudg.databinding.ListElementNudgBinding
import chris.did.presentation.nudgviewmodel.NudgViewModel

/**
 * NudgListAdapter
 */
class NudgListAdapter(private var nudgs: List<NudgViewModel>) :
    RecyclerView.Adapter<NudgListViewHolder>() {

    private var layoutInflater: LayoutInflater? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NudgListViewHolder {
        layoutInflater ?:let {
            layoutInflater = LayoutInflater.from(parent.context)
        }
        val binding: ListElementNudgBinding =
            DataBindingUtil.inflate(layoutInflater!!, R.layout.list_element_nudg, parent, false)
        return NudgListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NudgListViewHolder, position: Int) {
        holder.binding.viewModel = nudgs[position]
    }

    override fun getItemCount() = nudgs.size
}