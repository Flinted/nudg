package chris.did.presentation.nudg.tag

/**
 * Tag
 */

interface Tag {

    val tag: String

    fun getFormattedTag() = "#$tag"
}
