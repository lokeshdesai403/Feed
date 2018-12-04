package com.feed.webservice.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseResult(
    @SerializedName("hits")
    @Expose
    public var hits: List<HintModel>? = null,
    @SerializedName("nbHits")
    @Expose
    public var nbHits: Int? = null,
    @SerializedName("page")
    @Expose
    public var page: Int? = null,
    @SerializedName("nbPages")
    @Expose
    public var nbPages: Int? = null,
    @SerializedName("hitsPerPage")
    @Expose
    public var hitsPerPage: Int? = null,
    @SerializedName("processingTimeMS")
    @Expose
    public var processingTimeMS: Int? = null,
    @SerializedName("exhaustiveNbHits")
    @Expose
    public var exhaustiveNbHits: Boolean? = null,
    @SerializedName("query")
    @Expose
    public var query: String? = null,
    @SerializedName("params")
    @Expose
    public var params: String? = null
){}