package com.rkm.bhagavadgita.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import com.rkm.bhagavadgita.model.Commentary


class Converters {



    @TypeConverter
    fun fromString1(value: String?): MutableList<Commentary>? {
        if (value.isNullOrEmpty()) {
            return null
        }
        val gson = Gson()
        return try {
            gson.fromJson(value, object : TypeToken<MutableList<Commentary>>() {}.type)
        } catch (e: JsonSyntaxException) {
            // Handle potential JSON parsing errors here (optional)
            e.printStackTrace()
            null
        }
    }

    @TypeConverter
    fun toString1(list: MutableList<Commentary>?) =
        Gson().toJson(list, object : TypeToken<MutableList<Commentary>>() {}.type)
}
