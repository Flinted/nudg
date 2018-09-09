package chris.did.presentation.nudgviewmodelfactory

import chris.did.presentation.nudg.section.Section
import chris.did.presentation.nudgviewmodel.sectionviewmodel.SectionViewModel

/**
 * SectionViewModelCreator
 */
interface SectionViewModelCreator {

    fun create(sections: List<Section>): List<SectionViewModel>
}
