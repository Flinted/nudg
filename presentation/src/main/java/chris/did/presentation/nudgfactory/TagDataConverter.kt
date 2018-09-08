package chris.did.presentation.nudgfactory

import chris.did.data.TagData
import chris.did.presentation.nudg.tag.Tag

/**
 * TagDataConverter
 */
interface TagDataConverter {

    fun convertToTagData(tag: Tag): TagData
    fun convertAllToTagData(tags: List<Tag>): List<TagData>
    fun convertToTag(data: TagData): Tag
    fun convertAllToTag(data: List<TagData>): List<Tag>
}
