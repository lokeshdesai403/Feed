package com.feed.webservice.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HighlightResultModel(
    @SerializedName("title")
    @Expose
    public var title: TitleModel? = null,
    @SerializedName("url")
    @Expose
    public var url: UrlModel? = null,
    @SerializedName("author")
    @Expose
    public var author: AuthorModel? = null,
    @SerializedName("story_text")
    @Expose
    public var storyText: StoryTextModel? = null
)