package chris.did.nudg.nudglist

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filterable
import android.widget.TextView
import chris.did.nudg.R
import chris.did.nudg.databinding.ListElementNudgBinding
import chris.did.nudg.databinding.ListElementNudgDeletedBinding
import chris.did.presentation.nudgviewmodel.DeletedNudgViewModel
import chris.did.presentation.nudgviewmodel.NudgViewModel
import chris.did.presentation.nudgviewmodel.sectionviewmodel.DateTagViewModel
import chris.did.presentation.nudgviewmodel.sectionviewmodel.SectionViewModel
import chris.did.presentation.nudgviewmodel.sectionviewmodel.SystemTagViewModel


/**
 * NudgListAdapter
 */
class NudgListAdapter(nudgs: List<NudgViewModel>) :
    RecyclerView.Adapter<NudgListViewHolder>(), Filterable, NudgFilterCallback {

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
        if (holder.binding is ListElementNudgBinding) {
            val context = holder.binding.elementNudgTagRecycler.context
            holder.binding.elementNudgTagRecycler.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            holder.binding.elementNudgTagRecycler.adapter = TagListAdapter(nudg.getSections(), layoutInflater)
        }
    }

    override fun getItemCount() = filteredNudgs.size

    override fun getItemViewType(position: Int): Int {
        return when (filteredNudgs[position]) {
            is DeletedNudgViewModel -> R.layout.list_element_nudg_deleted
            else                    -> R.layout.list_element_nudg
        }
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


class TagListAdapter(
    private val tags: List<SectionViewModel>,
    private val layoutInflater: LayoutInflater?
) :
    RecyclerView.Adapter<TagListAdapter.TagViewHolder>() {

    class TagViewHolder(val view: TextView) : RecyclerView.ViewHolder(view) {}

    override fun getItemCount(): Int {
        return tags.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        return TagViewHolder((layoutInflater?.inflate(R.layout.list_tag, parent, false)) as TextView)
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        holder.view.text = tags[position].getFormattedValue()
        val color = when(tags[position]) {
            is SystemTagViewModel -> Color.RED
            is DateTagViewModel -> Color.YELLOW
            else -> Color.GREEN
        }
        holder.view.background.setColorFilter(color, PorterDuff.Mode.SRC_IN)
    }
}
