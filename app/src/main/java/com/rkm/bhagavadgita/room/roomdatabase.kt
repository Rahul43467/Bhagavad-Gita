package com.rkm.bhagavadgita.room


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities =[verse::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class roomdatabase(): RoomDatabase() {

    abstract fun chapterdao():dao

    companion object{

        private var INSTANCE: roomdatabase?=null

        fun getdbcopy(context: Context):roomdatabase{

            synchronized(this){

                if(INSTANCE==null){

                    INSTANCE = Room.databaseBuilder(context.applicationContext,roomdatabase::class.java,"verse").build()
                }
            }


            return INSTANCE!!

        }





    }

}