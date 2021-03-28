package com.example.itunesmusicsearch.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.itunesmusicsearch.repository.SearchRepository

//this is to make use of the viewModel in repository
class SearchViewModelProviderFactory(val searchRepository: SearchRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchViewModel(searchRepository) as T
    }
}