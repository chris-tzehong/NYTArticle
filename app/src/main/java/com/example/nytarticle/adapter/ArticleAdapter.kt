package com.example.nytarticle.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nytarticle.Result
import com.example.nytarticle.databinding.ArticleViewholderBinding

class ArticleAdapter(private val articleList: List<Result>): RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ArticleViewholderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val result: Result = articleList[position]
        holder.bind(result)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    class ArticleViewHolder(private val binding: ArticleViewholderBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(result: Result) {
            binding.articleTitle.text = result.title
            binding.articlePublishDate.text = result.publishedDate
        }
    }
}