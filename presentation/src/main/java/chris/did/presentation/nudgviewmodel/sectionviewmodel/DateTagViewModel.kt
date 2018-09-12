package chris.did.presentation.nudgviewmodel.sectionviewmodel

import chris.did.presentation.nudg.section.Section

/**
 * DateTagViewModel
 */
class DateTagViewModel(private val tag: Section) : SectionViewModel {

    override fun getId() = tag.id
    override fun getFormattedValue() = tag.value
}
