package com.feed.webservice.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class HintModel(
    @SerializedName("created_at")
    @Expose
    public var createdAt: String? = null,
    @SerializedName("title")
    @Expose
    public var title: String? = null,
    @SerializedName("url")
    @Expose
    public var url: String? = null,
    @SerializedName("author")
    @Expose
    public var author: String? = null,
    @SerializedName("points")
    @Expose
    public var points: Int? = null,
    @SerializedName("story_text")
    @Expose
    public var storyText: Any? = null,
    @SerializedName("comment_text")
    @Expose
    public var commentText: Any? = null,
    @SerializedName("num_comments")
    @Expose
    public var numComments: Int? = null,
    @SerializedName("story_id")
    @Expose
    public var storyId: Any? = null,
    @SerializedName("story_title")
    @Expose
    public var storyTitle: Any? = null,
    @SerializedName("story_url")
    @Expose
    public var storyUrl: Any? = null,
    @SerializedName("parent_id")
    @Expose
    public var parentId: Any? = null,
    @SerializedName("created_at_i")
    @Expose
    public var createdAtI: Int? = null,
    @SerializedName("_tags")
    @Expose
    public var tags: List<String>? = null,
    @SerializedName("objectID")
    @Expose
    public var objectID: String? = null,
    @SerializedName("_highlightResult")
    @Expose
    public var highlightResult: HighlightResultModel? = null
){}