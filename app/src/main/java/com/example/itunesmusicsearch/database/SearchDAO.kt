package com.example.itunesmusicsearch.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.itunesmusicsearch.api.models.Result

@Dao
interface SearchDAO {

    @Query("SELECT * FROM SearchResults")
    fun getAllResults(): LiveData<List<Result>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(result: Result)
}