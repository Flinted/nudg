package chris.did.presentation.nudgfactory

import chris.did.presentation.nudg.tag.Tag

/**
 * TagExtractor
 */
interface TagParser {

    fun parseTags(string: String): List<Tag>
}
