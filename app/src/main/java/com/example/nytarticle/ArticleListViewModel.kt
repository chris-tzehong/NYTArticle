package com.example.nytarticle

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ArticleListViewModel: ViewModel() {

    var articleListRepository = ArticleListRepository()

    fun getMostViewedList(apiKey: String): MutableLiveData<ListedArticle> {
        return articleListRepository.getMostViewedList(apiKey)
    }

    fun getMostSharedList(apiKey: String): MutableLiveData<ListedArticle> {
        return articleListRepository.getMostSharedList(apiKey)
    }

    fun getMostEmailedList(apiKey: String): MutableLiveData<ListedArticle> {
        return articleListRepository.getMostEmailedList(apiKey)
    }

    fun getSearchedList(apiKey: String, keyword: String): MutableLiveData<SearchedArticle> {
        return articleListRepository.getSearchedList(apiKey, keyword)
    }
}