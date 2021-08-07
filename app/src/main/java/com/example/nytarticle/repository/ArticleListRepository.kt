package com.example.nytarticle.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.nytarticle.ListedArticle
import com.example.nytarticle.SearchedArticle
import com.example.nytarticle.utils.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleListRepository {

    fun getMostViewedList(apiKey: String): MutableLiveData<ListedArticle> {

        val resultList = MutableLiveData<ListedArticle>()
        val call = RetrofitClient.apiInterface.getMostViewedList(apiKey)

        call.enqueue(object: Callback<ListedArticle> {
            override fun onFailure(call: Call<ListedArticle>, t: Throwable) {
                Log.v("DEBUG:", t.message.toString())
            }

            override fun onResponse(call: Call<ListedArticle>, response: Response<ListedArticle>) {
                Log.v("DEBUG:", response.body().toString())
                val data = response.body()
                resultList.value = data!!
            }
        })

        return resultList
    }

    fun getMostSharedList(apiKey: String): MutableLiveData<ListedArticle> {

        val resultList = MutableLiveData<ListedArticle>()
        val call = RetrofitClient.apiInterface.getMostSharedList(apiKey)

        call.enqueue(object: Callback<ListedArticle> {
            override fun onFailure(call: Call<ListedArticle>, t: Throwable) {
                Log.v("DEBUG:", t.message.toString())
            }

            override fun onResponse(call: Call<ListedArticle>, response: Response<ListedArticle>) {
                Log.v("DEBUG:", response.body().toString())
                val data = response.body()
                resultList.value = data!!
            }
        })

        return resultList
    }

    fun getMostEmailedList(apiKey: String): MutableLiveData<ListedArticle> {

        val resultList = MutableLiveData<ListedArticle>()
        val call = RetrofitClient.apiInterface.getMostEmailedList(apiKey)

        call.enqueue(object: Callback<ListedArticle> {
            override fun onFailure(call: Call<ListedArticle>, t: Throwable) {
                Log.v("DEBUG:", t.message.toString())
            }

            override fun onResponse(call: Call<ListedArticle>, response: Response<ListedArticle>) {
                Log.v("DEBUG:", response.body().toString())
                val data = response.body()
                resultList.value = data!!
            }
        })

        return resultList
    }

    fun getSearchedList(apiKey: String, keyword: String): MutableLiveData<SearchedArticle> {

        val resultList = MutableLiveData<SearchedArticle>()
        val call = RetrofitClient.apiInterface.getSearchedList(apiKey, keyword)

        call.enqueue(object: Callback<SearchedArticle> {
            override fun onFailure(call: Call<SearchedArticle>, t: Throwable) {
                Log.v("DEBUG:", t.message.toString())
            }

            override fun onResponse(call: Call<SearchedArticle>, response: Response<SearchedArticle>) {
                Log.v("DEBUG:", response.body().toString())
                val data = response.body()
                resultList.value = data!!
            }
        })

        return resultList
    }
}