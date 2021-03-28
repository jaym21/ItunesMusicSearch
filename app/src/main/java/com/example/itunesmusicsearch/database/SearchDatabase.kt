package com.example.itunesmusicsearch.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.itunesmusicsearch.api.models.Result

@Database(entities = [Result::class], version = 1)
abstract class SearchDatabase: RoomDatabase() {

    //to get DAO
    abstract fun getSearchDAO(): SearchDAO

    companion object {
        @Volatile //volatile is added so other threads can see when this instance is changed
        private var instance: SearchDatabase? = null
        private val LOCK = Any() //used to synchronize instance

        //when database is initialized invoke function is called
        operator fun invoke(context: Context) = instance?: synchronized(LOCK) { //if instance is null then the we lock so no other thread can access db is already in use by a thread
            instance?: createDatabase(context).also { instance = it}
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            SearchDatabase::class.java,
            "searchDB"
        ).build()
    }
}
