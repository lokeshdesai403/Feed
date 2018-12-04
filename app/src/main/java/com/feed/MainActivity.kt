package com.feed

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.Toast
import com.feed.adapter.FeedAdapter
import com.feed.base.BaseActivity
import com.feed.extensions.isConnected
import com.feed.webservice.ApiInterface
import com.feed.webservice.RestClient
import com.feed.webservice.model.HintModel
import com.feed.webservice.model.ResponseResult
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : BaseActivity() {

    private lateinit var feedAdapter: FeedAdapter
    private lateinit var listOfFeeds: MutableList<HintModel>
    var loading = false
    var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        listOfFeeds = mutableListOf()
        feedAdapter = FeedAdapter()
        feedRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        feedAdapter.listOfFeed = listOfFeeds
        feedRecyclerView.adapter = feedAdapter

        feedRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val linearLayoutManager = recyclerView
                        .layoutManager as LinearLayoutManager

                if (!loading && linearLayoutManager.itemCount <= linearLayoutManager.findLastVisibleItemPosition() + 5) {
                    loading = true
                    page += 1
                    if (isConnected())
                        fetchAllFeeds("story", page.toString())
                }
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }
        })

        if (isConnected()) {
            showLoader(this@MainActivity)
            fetchAllFeeds("story", page.toString())
        } else {
            feedRecyclerView.visibility = View.GONE
            textNoData.visibility = View.VISIBLE
            Toast.makeText(this@MainActivity, "Internet not available", Toast.LENGTH_SHORT).show()
        }
    }

    private fun fetchAllFeeds(task: String, page: String) {
        val apiService = RestClient.getClient()?.create(ApiInterface::class.java)
        val call = apiService?.getAllFeeds(task, page)
        call?.enqueue(object : Callback<ResponseResult> {
            override fun onFailure(call: Call<ResponseResult>, t: Throwable) {
                Log.e("ERROR", t.message)
            }

            override fun onResponse(call: Call<ResponseResult>, response: Response<ResponseResult>) {
                if (response.isSuccessful) {
                    val responseData = response.body() as ResponseResult
                    if (responseData.hits != null) {
                        listOfFeeds.addAll(responseData.hits!!.toMutableList())
                        feedAdapter.listOfFeed = listOfFeeds
                        feedAdapter.notifyDataSetChanged()
                        loading = false
                    }
                    textRecordCount.text = "Total Hits ${listOfFeeds.size + 1}"
                    if (listOfFeeds.size == 0) {
                        feedRecyclerView.visibility = View.GONE
                        textNoData.visibility = View.VISIBLE
                    } else {
                        feedRecyclerView.visibility = View.VISIBLE
                        textNoData.visibility = View.GONE
                    }
                    hideLoader()
                } else {
                    Toast.makeText(this@MainActivity, response.message(), Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}
