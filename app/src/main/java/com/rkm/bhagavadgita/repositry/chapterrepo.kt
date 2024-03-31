package com.rkm.bhagavadgita.repositry

import com.rkm.bhagavadgita.room.allchaptersroom
import com.rkm.bhagavadgita.room.chapterdao
import com.rkm.bhagavadgita.room.dao


class chapterrepo(val chapterdao: chapterdao) {


    suspend fun readchapter(): List<allchaptersroom> {

        return chapterdao.readchapterlist()
    }

}