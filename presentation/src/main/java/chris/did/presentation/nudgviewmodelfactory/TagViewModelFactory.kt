package chris.did.presentation.nudgviewmodelfactory

import chris.did.presentation.nudg.tag.DateTag
import chris.did.presentation.nudg.tag.SystemTag
import chris.did.presentation.nudg.tag.Tag
import chris.did.presentation.nudgviewmodel.tagviewmodel.DateTagViewModel
import chris.did.presentation.nudgviewmodel.tagviewmodel.SystemTagViewModel
import chris.did.presentation.nudgviewmodel.tagviewmodel.TagViewModel
import chris.did.presentation.nudgviewmodel.tagviewmodel.UserTagViewModel

/**
 * TagViewModelFactory
 */
class TagViewModelFactory : TagViewModelCreator {

    override fun create(tags: List<Tag>): List<TagViewModel> {
        return tags.map { tag ->
            when (tag) {
                is DateTag   -> DateTagViewModel(tag)
                is SystemTag -> SystemTagViewModel(tag)
                else         -> UserTagViewModel(tag)
            }
        }
    }
}