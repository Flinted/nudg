package chris.did.presentation.nudgviewmodel

import chris.did.presentation.nudgviewmodel.sectionviewmodel.SectionViewModel
import java.util.*

/**
 * NudgViewModel
 */
interface NudgViewModel {

    fun getId(): UUID
    fun getBuiltText(): String
    fun getNotes(): String
    fun getSections(): List<SectionViewModel>
    fun getSectionsText(): String
}
