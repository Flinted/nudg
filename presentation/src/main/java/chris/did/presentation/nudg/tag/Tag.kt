package chris.did.presentation.nudg.tag

import java.util.*

/**
 * Tag
 */

interface Tag {

    val id: UUID
    val tag: String

    fun getFormattedTag() = "#$tag"
}
