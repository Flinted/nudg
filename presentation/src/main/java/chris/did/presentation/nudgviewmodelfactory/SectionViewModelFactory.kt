package chris.did.presentation.nudgviewmodelfactory

import chris.did.presentation.nudg.section.DateTagSection
import chris.did.presentation.nudg.section.Section
import chris.did.presentation.nudg.section.SystemTagSection
import chris.did.presentation.nudgviewmodel.sectionviewmodel.DateTagViewModel
import chris.did.presentation.nudgviewmodel.sectionviewmodel.SectionViewModel
import chris.did.presentation.nudgviewmodel.sectionviewmodel.SystemTagViewModel
import chris.did.presentation.nudgviewmodel.sectionviewmodel.UserTagViewModel

/**
 * SectionViewModelFactory
 */
class SectionViewModelFactory : SectionViewModelCreator {

    override fun create(sections: List<Section>): List<SectionViewModel> {
        return sections.map { section -> convertSectionToViewModel(section) }
    }

    private fun convertSectionToViewModel(section: Section): SectionViewModel {
        return when (section) {
            is DateTagSection   -> DateTagViewModel(section)
            is SystemTagSection -> SystemTagViewModel(section)
            else                -> UserTagViewModel(section)
        }
    }
}
