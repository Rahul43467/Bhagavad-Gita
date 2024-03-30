package com.rkm.bhagavadgita.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface dao {

    @Insert
    suspend fun insertchapter(allchaptersroom: allchaptersroom)

    @Query("SELECT * FROM chapter")
    fun readchapter(): LiveData<List<allchaptersroom>>



}