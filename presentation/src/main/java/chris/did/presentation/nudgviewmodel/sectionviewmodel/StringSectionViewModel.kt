package chris.did.presentation.nudgviewmodel.sectionviewmodel

import chris.did.presentation.nudg.section.Section

/**
 * StringSectionViewModel
 */
class StringSectionViewModel(private val stringSection: Section) : SectionViewModel {

    override fun getId() = stringSection.id

    override fun getFormattedValue() = stringSection.value
}
