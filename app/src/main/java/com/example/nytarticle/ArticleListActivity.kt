package com.example.nytarticle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytarticle.databinding.ActivityArticleListBinding

class ArticleListActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var binding: ActivityArticleListBinding
    lateinit var articleListViewModel: ArticleListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loadingCover.root.visibility = View.VISIBLE

        binding.toolbar.inflateMenu(R.menu.menu_article_list)
        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.homepage -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                else -> true
            }
        }

        val intentType = intent.getSerializableExtra(INTENT_TYPE) as? IntentType

        articleListViewModel = ViewModelProvider(this).get(ArticleListViewModel::class.java)
        var resultList = arrayListOf<Result>()

        linearLayoutManager = LinearLayoutManager(this)
        binding.articleList.layoutManager = linearLayoutManager

        val articleAdapter = ArticleAdapter(resultList)
        binding.articleList.adapter = articleAdapter

        when (intentType) {
            IntentType.MOST_VIEWED -> {
                articleListViewModel.getMostViewedList(RetrofitClient.apiKey)
                    .observe(this, Observer {
                        binding.loadingCover.root.visibility = View.GONE
                        resultList.addAll(it.results!!)
                        articleAdapter.notifyDataSetChanged()
                    })
            }
            IntentType.MOST_EMAILED -> {
                articleListViewModel.getMostEmailedList(RetrofitClient.apiKey)
                    .observe(this, Observer {
                        binding.loadingCover.root.visibility = View.GONE
                    resultList.addAll(it.results!!)
                    articleAdapter.notifyDataSetChanged()
                })
            }
            IntentType.MOST_SHARED -> {
                articleListViewModel.getMostSharedList(RetrofitClient.apiKey).observe(this, Observer {
                    binding.loadingCover.root.visibility = View.GONE
                    resultList.addAll(it.results!!)
                    articleAdapter.notifyDataSetChanged()
                })
            }
            IntentType.SEARCH -> {
                val keyword = intent.getStringExtra(SEARCH_EXTRA) as String
                articleListViewModel.getSearchedList(RetrofitClient.apiKey, keyword).observe(this, Observer { searchedArticle ->
                    searchedArticle.response?.docs?.forEach {
                        val result = Result(it.publishDate, it.headline?.main)
                        resultList.add(result)
                    }
                    binding.loadingCover.root.visibility = View.GONE
                    articleAdapter.notifyDataSetChanged()
                })
            }
        }

    }

    companion object {
        val INTENT_TYPE = "INTENT_TYPE"
        val SEARCH_EXTRA = "SEARCH_EXTRA"
    }
}