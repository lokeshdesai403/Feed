package com.feed.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.feed.R
import com.feed.webservice.model.HintModel

class FeedAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var listOfFeed = mutableListOf<HintModel>()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecyclerView.ViewHolder {
        return FeedViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.list_feed_layout, parent, false))
    }

    override fun getItemCount(): Int = listOfFeed.size

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        (viewHolder as FeedViewHolder).bind(listOfFeed[position])
    }
}