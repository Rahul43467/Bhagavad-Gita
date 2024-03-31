package com.rkm.bhagavadgita.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface dao {



    @Query("SELECT * FROM VERSE")
    suspend fun readverse(): List<verse>

    @Query("SELECT * FROM VERSE WHERE chapter_number = :chapternumber")
    suspend fun readchapter(chapternumber : Int) : List<verse>




    @Query("SELECT * FROM VERSE WHERE chapter_number = :chapternumber AND  verse_number = :versenumber")
    suspend fun readsingleverse(chapternumber: Int,versenumber : Int): verse





}