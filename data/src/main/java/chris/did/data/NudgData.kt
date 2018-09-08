package chris.did.data

/**
 * NudgData
 */
interface NudgData {
    val id: String
    val text: String
    val tags: List<TagData>
    val deleted: Boolean
}