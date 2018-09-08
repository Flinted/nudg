package chris.did.presentation.nudgviewmodel.tagviewmodel

import chris.did.presentation.nudg.tag.Tag

/**
 * SystemTagViewModel
 */
class SystemTagViewModel(private val tag: Tag) : TagViewModel {

    override fun getId() = tag.id
    override fun getFormattedTag() = "#${tag.tag}"
}
