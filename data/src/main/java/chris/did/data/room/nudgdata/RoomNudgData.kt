package chris.did.data.room.nudgdata

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import chris.did.data.room.sectiondata.RoomSectionData

/**
 * RoomNudgData
 */
@Entity()
class RoomNudgData(
    @PrimaryKey val id: String,
    @TypeConverters(SectionConverter::class)
    @ColumnInfo(name = "sections") val sections: ArrayList<RoomSectionData>,
    @ColumnInfo(name = "deleted") val deleted: Boolean
) {}
