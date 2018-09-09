package chris.did.data.room.nudgdata

import android.arch.persistence.room.TypeConverter
import chris.did.data.room.sectiondata.RoomSectionData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * SectionConverter
 */
class SectionConverter {

    @TypeConverter
    fun fromCountryLangList(value: ArrayList<RoomSectionData>): String {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<RoomSectionData>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toCountryLangList(value: String): ArrayList<RoomSectionData> {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<RoomSectionData>>() {}.type
        return gson.fromJson(value, type)
    }
}
