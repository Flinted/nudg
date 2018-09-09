package chris.did.presentation.nudgviewmodelfactory

import chris.did.presentation.nudg.section.DateTagSection
import chris.did.presentation.nudg.section.Section
import chris.did.presentation.nudg.section.SystemTagSection
import chris.did.presentation.nudg.section.UserTagSection
import chris.did.presentation.nudgviewmodel.sectionviewmodel.*

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
            is UserTagSection   -> UserTagViewModel(section)
            else                -> StringSectionViewModel(section)
        }
    }
}
