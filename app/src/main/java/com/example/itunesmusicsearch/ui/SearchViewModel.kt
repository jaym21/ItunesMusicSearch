package com.example.itunesmusicsearch.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itunesmusicsearch.api.models.ResponseApi
import com.example.itunesmusicsearch.repository.SearchRepository
import com.example.itunesmusicsearch.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class SearchViewModel (val searchRepository: SearchRepository): ViewModel() {

    //getting the searchResults as mutableLiveData in the viewModel
    val searchResults: MutableLiveData<Response<ResponseApi>> = MutableLiveData()

    fun getResults(term: String) = viewModelScope.launch{

        val response = searchRepository.getSearchResults(term)
        searchResults.value = response
    }


}