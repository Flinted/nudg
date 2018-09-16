package chris.did.nudg.nudglist

import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import chris.did.nudg.R
import chris.did.presentation.nudgviewmodel.sectionviewmodel.DateTagViewModel
import chris.did.presentation.nudgviewmodel.sectionviewmodel.SectionViewModel
import chris.did.presentation.nudgviewmodel.sectionviewmodel.SystemTagViewModel

/**
 * TagListAdapter
 */
class TagListAdapter(
    private val tags: List<SectionViewModel>,
    private val layoutInflater: LayoutInflater?,
    private val listener: TagListAdapterListener?
) :
    RecyclerView.Adapter<TagListAdapter.TagViewHolder>() {

    class TagViewHolder(val view: TextView) : RecyclerView.ViewHolder(view) {}

    override fun getItemCount(): Int {
        return tags.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        return TagViewHolder(
            (layoutInflater?.inflate(
                R.layout.list_tag,
                parent,
                false
            )) as TextView
        )
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        val tag = tags[position]
        holder.view.text = tag.getFormattedValue()
        val color = when (tag) {
            is SystemTagViewModel -> Color.RED
            is DateTagViewModel   -> Color.YELLOW
            else                  -> Color.GREEN
        }
        holder.view.setOnClickListener {
            listener?.onTagSelected(tag.getId())
        }
        holder.view.background.setColorFilter(color, PorterDuff.Mode.SRC_IN)
    }
}