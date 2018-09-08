package chris.did.presentation.nudgviewmodelfactory

import chris.did.presentation.nudg.tag.Tag
import chris.did.presentation.nudgviewmodel.tagviewmodel.TagViewModel

/**
 * TagViewModelCreator
 */
interface TagViewModelCreator {

    fun create(tags: List<Tag>): List<TagViewModel>
}