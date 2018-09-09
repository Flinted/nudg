package chris.did.data.room.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import chris.did.data.room.nudgdata.RoomNudgData

/**
 * NudgDao
 */
@Dao
interface NudgDao {
    @Query("SELECT * FROM RoomNudgData")
    fun getAll(): List<RoomNudgData>

    @Insert(onConflict = REPLACE)
    fun insert(nudgData: RoomNudgData)

    @Query("DELETE from RoomNudgData")
    fun deleteAll()
}
