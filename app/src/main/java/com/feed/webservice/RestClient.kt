package com.feed.webservice


import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestClient {
    companion object {
        var retrofit: Retrofit? = null
        fun getClient(): Retrofit? {

            val logging = HttpLoggingInterceptor()
            // set your desired log level
            logging.level = HttpLoggingInterceptor.Level.BODY
            val httpClient = OkHttpClient.Builder()
            // add your other interceptors …
            // add logging as last interceptor
            httpClient.addInterceptor(logging)  // <-- this is the important line!
            val gson = GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create()
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(WebConstants.WS_SERVER_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient.build())
                    .build()
            }
            return retrofit
        }
    }
}