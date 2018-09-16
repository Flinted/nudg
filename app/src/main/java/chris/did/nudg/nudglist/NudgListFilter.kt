package chris.did.nudg.nudglist

import android.widget.Filter
import chris.did.presentation.nudgviewmodel.NudgViewModel

/**
 * NudgListFilter
 */

interface NudgFilterListener {

    fun didFilter(filtered: List<NudgViewModel>)
}

class NudgListFilter(
    private var original: List<NudgViewModel>,
    private var listener: NudgFilterListener
) :
    Filter() {
    override fun performFiltering(constraint: CharSequence): FilterResults {
        val filteredResults = getFilteredResults(constraint)
        val results = Filter.FilterResults()
        results.values = filteredResults

        return results
    }

    private fun getFilteredResults(constraint: CharSequence): List<NudgViewModel> {
        if (constraint.isBlank() || constraint.length < 3) {
            return original
        }
        return original.filter { nudg ->
            nudg.getBuiltText().toLowerCase().contains(constraint.toString().toLowerCase())
        }
    }

    override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
        listener.didFilter(p1?.values as List<NudgViewModel>)
    }
}
