package chris.did.presentation.nudgfactory

import chris.did.data.NudgData
import chris.did.data.RealmNudgData
import chris.did.presentation.nudg.DeletedNudg
import chris.did.presentation.nudg.Nudg
import chris.did.presentation.nudg.UserNudg
import java.util.*

/**
 * NudgFactory
 */
class NudgFactory(private val tagFactory: TagParser) : NudgCreator, NudgDataConverter {

    override fun createNewNudg(input: String): Nudg {
        val tags = tagFactory.parseTags(input)
        return UserNudg(UUID.randomUUID(), input, tags)
    }

    override fun convertToNudgData(nudg: Nudg): NudgData {
        val isDeleted = nudg is DeletedNudg
        val tagData = (tagFactory as TagDataConverter).convertAllToTagData(nudg.tags)
        return RealmNudgData(nudg.id.toString(), nudg.text, tagData, isDeleted)
    }

    override fun convertToNudg(data: NudgData): Nudg {
        val id = UUID.fromString(data.id)
        val tags = (tagFactory as TagDataConverter).convertAllToTag(data.tags)
        return when {
            data.deleted -> DeletedNudg(id, data.text, tags)
            else         -> UserNudg(id, data.text, tags)
        }
    }
}
