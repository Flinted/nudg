package chris.did.presentation.nudgviewmodel.tagviewmodel

import chris.did.presentation.nudg.tag.Tag

/**
 * DateTagViewModel
 */
class DateTagViewModel(private val tag: Tag) : TagViewModel {

    override fun getId() = tag.id
    override fun getFormattedTag() = "#${tag.tag}"
}
