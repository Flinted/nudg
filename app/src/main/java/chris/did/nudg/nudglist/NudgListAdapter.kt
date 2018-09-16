package chris.did.nudg.nudglist

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filterable
import chris.did.nudg.R
import chris.did.nudg.databinding.ListElementNudgBinding
import chris.did.nudg.databinding.ListElementNudgDeletedBinding
import chris.did.presentation.nudgviewmodel.DeletedNudgViewModel
import chris.did.presentation.nudgviewmodel.NudgViewModel
import java.util.*


/**
 * NudgListAdapter
 */
class NudgListAdapter(
    nudgs: List<NudgViewModel>,
    private val listener: NudgListAdapterListener?
) : RecyclerView.Adapter<NudgListViewHolder>(),
    Filterable,
    NudgFilterListener,
    TagListAdapterListener {

    private var layoutInflater: LayoutInflater? = null
    private var filter = NudgListFilter(nudgs, this)
    private var filteredNudgs = nudgs

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NudgListViewHolder {
        layoutInflater ?: let {
            layoutInflater = LayoutInflater.from(parent.context)
        }
        val binding: ViewDataBinding =
            DataBindingUtil.inflate(layoutInflater!!, viewType, parent, false)
        return NudgListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NudgListViewHolder, position: Int) {
        val nudg = filteredNudgs[position]
        when (holder.binding) {
            is ListElementNudgDeletedBinding -> holder.binding.viewModel = nudg
            is ListElementNudgBinding        -> holder.binding.viewModel = nudg
            else                             -> return
        }
        holder.binding.root.setOnClickListener {
            listener?.onNudgSelected(nudg.getId())
        }
        if (holder.binding is ListElementNudgBinding) {
            val context = holder.binding.elementNudgTagRecycler.context
            holder.binding.elementNudgTagRecycler.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            holder.binding.elementNudgTagRecycler.adapter =
                    TagListAdapter(nudg.getSections(), layoutInflater, this)
        }
    }

    override fun getItemCount() = filteredNudgs.size

    override fun getItemViewType(position: Int): Int {
        return when (filteredNudgs[position]) {
            is DeletedNudgViewModel -> R.layout.list_element_nudg_deleted
            else                    -> R.layout.list_element_nudg
        }
    }

    override fun onTagSelected(id: UUID) {
        listener?.onTagSelected(id)
    }

    // Filterable
    override fun getFilter() = filter

    override fun didFilter(filtered: List<NudgViewModel>) {
        if (filteredNudgs == filtered) {
            return
        }
        filteredNudgs = filtered
        notifyDataSetChanged()
    }
}
