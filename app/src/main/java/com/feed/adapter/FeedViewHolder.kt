package com.feed.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.feed.constants.DateConstant
import com.feed.webservice.model.HintModel
import kotlinx.android.synthetic.main.list_feed_layout.view.*

class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(hintModel: HintModel) {
        itemView.textTitle.text = hintModel.title
        DateConstant.getDateFromString(hintModel.createdAt,
                DateConstant.GLOBAL_FORMAT)?.let { postDate ->
            itemView.textDate.text = DateConstant.getDateInString(postDate, DateConstant.MY_FORMAT)
        }
    }
}