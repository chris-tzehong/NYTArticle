package com.example.nytarticle

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.nytarticle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mostViewed.setOnClickListener {
            val intent = Intent(this, ArticleListActivity::class.java)
            intent.putExtra(ArticleListActivity.INTENT_TYPE, IntentType.MOST_VIEWED)
            startActivity(intent)
        }

        binding.mostShared.setOnClickListener {
            val intent = Intent(this, ArticleListActivity::class.java)
            intent.putExtra(ArticleListActivity.INTENT_TYPE, IntentType.MOST_SHARED)
            startActivity(intent)
        }

        binding.mostEmailed.setOnClickListener {
            val intent = Intent(this, ArticleListActivity::class.java)
            intent.putExtra(ArticleListActivity.INTENT_TYPE, IntentType.MOST_EMAILED)
            startActivity(intent)
        }

        binding.searchArticles.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

    }
}