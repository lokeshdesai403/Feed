package com.feed.webservice

import com.feed.webservice.model.ResponseResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("search_by_date")
    abstract fun getAllFeeds(@Query("tags") tags: String, @Query("page") page: String): Call<ResponseResult>
}