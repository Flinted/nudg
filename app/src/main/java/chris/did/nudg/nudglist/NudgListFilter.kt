package chris.did.nudg.nudglist

import android.widget.Filter
import chris.did.presentation.nudgviewmodel.NudgViewModel

/**
 * NudgListFilter
 */

interface NudgFilterCallback {
    fun didFilter(filtered: List<NudgViewModel>)
}

class NudgListFilter(
    private var original: List<NudgViewModel>,
    private var callback: NudgFilterCallback
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
            nudg.getBuiltText().toString().toLowerCase()
                .contains(constraint.toString().toLowerCase())
        }
    }

    override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
        callback.didFilter(p1?.values as List<NudgViewModel>)
    }
}
