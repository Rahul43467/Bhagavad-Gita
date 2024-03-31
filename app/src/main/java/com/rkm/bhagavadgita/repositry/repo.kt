package com.rkm.bhagavadgita.repositry

import androidx.lifecycle.LiveData
import com.rkm.bhagavadgita.room.allchaptersroom
import com.rkm.bhagavadgita.room.dao
import com.rkm.bhagavadgita.room.verse

class repo(val dao: dao) {




    suspend fun readverse(): List<verse>{

        return dao.readverse()

    }

    suspend fun readchapterverse(chapternumber : Int): List<verse>{

        return dao.readchapter(chapternumber)

    }

    suspend fun readsingleverse(chapternumber : Int,versenumber : Int): verse{

        return dao.readsingleverse(chapternumber,versenumber)

    }
}