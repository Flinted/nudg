package chris.did.presentation.nudgviewmodelfactory

import chris.did.presentation.nudg.section.DateTagSection
import chris.did.presentation.nudg.section.SystemTagSection
import chris.did.presentation.nudg.section.Section
import chris.did.presentation.nudgviewmodel.sectionviewmodel.DateTagViewModel
import chris.did.presentation.nudgviewmodel.sectionviewmodel.SystemTagViewModel
import chris.did.presentation.nudgviewmodel.sectionviewmodel.SectionViewModel
import chris.did.presentation.nudgviewmodel.sectionviewmodel.UserTagViewModel

/**
 * TagViewModelFactory
 */
class TagViewModelFactory : TagViewModelCreator {

    override fun create(tags: List<Section>): List<SectionViewModel> {
        return tags.map { tag ->
            when (tag) {
                is DateTagSection   -> DateTagViewModel(tag)
                is SystemTagSection -> SystemTagViewModel(tag)
                else                -> UserTagViewModel(tag)
            }
        }
    }
}