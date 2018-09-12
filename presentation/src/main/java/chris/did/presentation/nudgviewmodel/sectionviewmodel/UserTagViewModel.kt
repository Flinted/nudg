package chris.did.presentation.nudgviewmodel.sectionviewmodel

import chris.did.presentation.nudg.section.Section

/**
 * UserTagViewModel
 */
data class UserTagViewModel(private val tag: Section) : SectionViewModel {

    override fun getId() = tag.id
    override fun getFormattedValue() = tag.value
}
