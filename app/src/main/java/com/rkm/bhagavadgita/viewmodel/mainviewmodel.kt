package com.rkm.bhagavadgita.viewmodel

import android.app.Application

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rkm.bhagavadgita.model.allchaptersdataItem
import com.rkm.bhagavadgita.model.verselistItem
import com.rkm.bhagavadgita.repositry.apprepositery
import com.rkm.bhagavadgita.repositry.repo
import com.rkm.bhagavadgita.room.allchaptersroom
import com.rkm.bhagavadgita.room.roomdatabase


class mainviewmodel(application: Application):AndroidViewModel(application) {
    val apprepositery = apprepositery()



    suspend fun getallchaptersv(): ArrayList<verselistItem>{

        return apprepositery.getallchaptersdata()
    }




}