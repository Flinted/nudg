package chris.did.presentation.nudgviewmodelfactory

import chris.did.presentation.nudg.section.Section
import chris.did.presentation.nudgviewmodel.sectionviewmodel.SectionViewModel

/**
 * TagViewModelCreator
 */
interface TagViewModelCreator {

    fun create(tags: List<Section>): List<SectionViewModel>
}