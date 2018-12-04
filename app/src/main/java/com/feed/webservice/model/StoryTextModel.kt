package com.feed.webservice.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class StoryTextModel(
    @SerializedName("value")
    @Expose
    public var value: String? = null,
    @SerializedName("matchLevel")
    @Expose
    public var matchLevel: String? = null,
    @SerializedName("matchedWords")
    @Expose
    public var matchedWords: List<String>? = null
)
