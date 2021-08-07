package com.example.nytarticle.utils

import com.example.nytarticle.ListedArticle
import com.example.nytarticle.SearchedArticle
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("svc/search/v2/articlesearch.json")
    fun getSearchedList(@Query("api-key") apiKey: String, @Query("q") queryKeyword: String): Call<SearchedArticle>

    @GET("svc/mostpopular/v2/viewed/7.json")
    fun getMostViewedList(@Query("api-key") apiKey: String): Call<ListedArticle>

    @GET("svc/mostpopular/v2/shared/1/facebook.json")
    fun getMostSharedList(@Query("api-key") apiKey: String): Call<ListedArticle>

    @GET("svc/mostpopular/v2/emailed/1.json")
    fun getMostEmailedList(@Query("api-key") apiKey: String): Call<ListedArticle>
}