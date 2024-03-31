package com.rkm.bhagavadgita.room

import androidx.room.Dao
import androidx.room.Query

@Dao
interface chapterdao {

    @Query("SELECT * FROM  chapter")
    suspend fun readchapterlist() : List<allchaptersroom>







}