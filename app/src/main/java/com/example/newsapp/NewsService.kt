package com.example.newsapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=in&apiKey=API_KEY
//https://newsapi.org/v2/everything?q=tesla&from=2023-08-26&sortBy=publishedAt&apiKey=API_KEY

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "23e1376f1ca840e286ff205c72ab4440"
interface NewsInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country")country:String,@Query("page") page:Int) : Call<News>

//    https://newsapi.org/v2/top-headlines?apiKey=$API_KEY&country=in&page=1
}

object NewsService{
    val newsInstance: NewsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}