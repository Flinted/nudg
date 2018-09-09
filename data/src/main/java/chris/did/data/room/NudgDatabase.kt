package chris.did.data.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import chris.did.data.room.dao.NudgDao
import chris.did.data.room.nudgdata.RoomNudgData
import chris.did.data.room.nudgdata.SectionConverter

/**
 * NudgDatabase
 */
@Database(entities = [RoomNudgData::class], version = 1)
@TypeConverters(SectionConverter::class)
abstract class NudgDatabase : RoomDatabase() {

    abstract fun nudgDao(): NudgDao

    companion object {
        private var INSTANCE: NudgDatabase? = null

        fun getInstance(context: Context): NudgDatabase? {
            INSTANCE?.let {
                return INSTANCE
            }
            synchronized(NudgDatabase::class) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    NudgDatabase::class.java, "nudg.db"
                ).build()
            }

            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
