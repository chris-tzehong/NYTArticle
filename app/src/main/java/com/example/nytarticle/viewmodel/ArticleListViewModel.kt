package com.example.nytarticle.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nytarticle.ListedArticle
import com.example.nytarticle.SearchedArticle
import com.example.nytarticle.repository.ArticleListRepository

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