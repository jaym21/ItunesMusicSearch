package com.example.itunesmusicsearch.util

//used to wrap around the repository for handling errors and responses from api
sealed class Resource<T>(val data: T? = null, val responseMessage: String? = null) {
    //for successful response with data from api
    class Success<T>(data: T): Resource<T>(data)

    //for failure in response from api
    class Error<T>(responseMessage: String): Resource<T>(null, responseMessage)

    //while fetching from api to show loading sign
    class Loading<T> : Resource<T>()
}