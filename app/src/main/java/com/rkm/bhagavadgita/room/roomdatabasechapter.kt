package com.rkm.bhagavadgita.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities =[allchaptersroom::class], version = 1, exportSchema = false)

abstract class roomdatabasechapter(): RoomDatabase() {

    abstract fun chapterdao(): chapterdao

    companion object{

        private var INSTANCE: roomdatabasechapter?=null

        fun getdbcopy(context: Context):roomdatabasechapter{

            synchronized(this){

                if(INSTANCE==null){

                    INSTANCE = Room.databaseBuilder(context.applicationContext,roomdatabasechapter::class.java,"chapter").build()
                }
            }


            return INSTANCE!!

        }





    }

}