package com.rkm.bhagavadgita.repositry

import androidx.lifecycle.LiveData
import com.rkm.bhagavadgita.room.allchaptersroom
import com.rkm.bhagavadgita.room.dao

class repo(val dao: dao) {

    suspend fun readchapter(): LiveData<List<allchaptersroom>> {

        return dao.readchapter()
    }

    suspend  fun insertchapter(allchaptersroom: allchaptersroom){
        dao.insertchapter(allchaptersroom)

    }
}