package com.example.nytarticle.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nytarticle.utils.IntentType
import com.example.nytarticle.R
import com.example.nytarticle.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            if (binding.searchBar.text.isEmpty()) {
                binding.searchBar.error = resources.getString(R.string.empty_search_error)
            } else {
                val intent = Intent(this, ArticleListActivity::class.java)
                intent.putExtra(ArticleListActivity.INTENT_TYPE, IntentType.SEARCH)
                intent.putExtra(ArticleListActivity.SEARCH_EXTRA, binding.searchBar.text.toString())
                binding.searchBar.text.clear()
                startActivity(intent)
            }
        }
    }
}