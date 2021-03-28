package com.example.itunesmusicsearch.repository

import com.example.itunesmusicsearch.api.RetrofitInstance
import com.example.itunesmusicsearch.api.SearchAPI
import com.example.itunesmusicsearch.api.models.ResponseApi
import com.example.itunesmusicsearch.api.models.Result
import com.example.itunesmusicsearch.database.SearchDatabase
import retrofit2.Response
import javax.inject.Inject

class SearchRepository(val database: SearchDatabase) {

    //to get search results for entered string from api
    suspend fun getSearchResults(term: String): Response<ResponseApi> {
        return RetrofitInstance.api.getSearchResults(term)
    }

    //to insert search results in DB
    suspend fun insertSearchResults(result: Result) = database.getSearchDAO().insert(result)
}