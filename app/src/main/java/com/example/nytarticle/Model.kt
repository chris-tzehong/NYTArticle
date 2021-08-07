package com.example.nytarticle

import com.google.gson.annotations.SerializedName

data class SearchedArticle(
    @SerializedName("status")
    var status: String?,
    @SerializedName("response")
    var response: Response?
)

data class Response(
    @SerializedName("docs")
    var docs: List<Docs>?
)

data class Docs(
    @SerializedName("headline")
    var headline: Headline?,
    @SerializedName("pub_date")
    var publishDate: String?
)

data class Headline(
    @SerializedName("main")
    var main: String?
)

data class ListedArticle(
    @SerializedName("status")
    var status: String?,
    @SerializedName("results")
    var results: List<Result>?
)

data class Result(
    @SerializedName("published_date")
    var publishedDate: String?,
    @SerializedName("title")
    var title: String?
)