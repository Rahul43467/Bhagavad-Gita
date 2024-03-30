package com.rkm.bhagavadgita.repositry


import com.rkm.bhagavadgita.model.allchaptersdataItem
import com.rkm.bhagavadgita.utils.retrofitinstance

import java.io.IOException


class apprepositery {

    suspend fun getallchaptersdata(): List<allchaptersdataItem> {

        val response = try {
            retrofitinstance.api.getchapters()
        } catch (e: IOException) {



        }
        return response as List<allchaptersdataItem>


    }
}
