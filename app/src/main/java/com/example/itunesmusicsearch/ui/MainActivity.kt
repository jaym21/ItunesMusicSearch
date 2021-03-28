package com.example.itunesmusicsearch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.itunesmusicsearch.R
import com.example.itunesmusicsearch.adapter.ResultsRVAdapter
import com.example.itunesmusicsearch.database.SearchDatabase
import com.example.itunesmusicsearch.databinding.ActivityMainBinding
import com.example.itunesmusicsearch.repository.SearchRepository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var searchResultsAdapter: ResultsRVAdapter
    lateinit var viewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        //initializing viewModel
        val searchRepository = SearchRepository(SearchDatabase(this)) //getting repository
        val viewModelProviderFactory = SearchViewModelProviderFactory(searchRepository) //creating viewModelProviderFactory
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(SearchViewModel::class.java)


        val enteredString = binding.etSearch.text

        binding.btnSearch.setOnClickListener {
            viewModel.getResults(enteredString.toString())
        }

        viewModel.searchResults.observe(this, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.let {
                    searchResultsAdapter.updateRV(it.results)
                }
            }
            Toast.makeText(this, "Enter in search box for results", Toast.LENGTH_SHORT).show()
        })

    }



    private fun setupRecyclerView() {
        searchResultsAdapter = ResultsRVAdapter()
        binding.rvSearchResult.adapter = searchResultsAdapter
        binding.rvSearchResult.layoutManager = LinearLayoutManager(this)
    }
}