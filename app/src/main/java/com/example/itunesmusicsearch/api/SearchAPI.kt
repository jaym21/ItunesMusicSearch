package com.example.itunesmusicsearch.api

import com.example.itunesmusicsearch.api.models.ResponseApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface SearchAPI {

    @GET("/search")
    suspend fun getSearchResults(
        @Query("term")
        term: String
    ):Response<ResponseApi>
}