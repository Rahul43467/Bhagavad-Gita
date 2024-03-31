package com.rkm.bhagavadgita.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.rkm.bhagavadgita.model.Commentary
import com.rkm.bhagavadgita.model.Translation

@Entity(tableName = "verse")
data class verse (val  chapter_number: Int,
                  @TypeConverters(Converters::class)
                  val commentaries: MutableList<Commentary>,
                  @PrimaryKey(autoGenerate = true)
                  val id: Int,
                  val text: String,
                  @TypeConverters(Converters::class)
                  val translations: MutableList<Commentary>,
                  val verse_number: Int)


