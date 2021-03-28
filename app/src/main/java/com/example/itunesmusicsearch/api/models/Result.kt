package com.example.itunesmusicsearch.api.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SearchResults")
data class Result(
    @PrimaryKey(autoGenerate = false)
    val artistId: Int,
    val artistName: String?,
    val artistViewUrl: String?,
    val artworkUrl100: String?,
    val artworkUrl30: String?,
    val artworkUrl60: String?,
    val collectionName: String?,
    val country: String?,
    val currency: String?,
    val kind: String?,
    val previewUrl: String?,
    val primaryGenreName: String?,
    val releaseDate: String?,
    val trackId: Int?,
    val trackName: String?,
    val trackNumber: Int?,
    val trackPrice: Double?,
    val trackTimeMillis: Long?,
    val trackViewUrl: String?,
)