package br.com.victorpajeu.books.http

import br.com.victorpajeu.books.model.SearchResult
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.Exception
import java.util.concurrent.TimeUnit

object BookHttp {

    val API_KEY = "AIzaSyCdybClbXIhr2QQtE2wEAQ6CyHFjr7Qq30"
    val BOOK_JSON_URL =
        "https://www.googleapis.com/books/v1/volumes?q=%s&key=$API_KEY"

    fun searchBook(q : String): SearchResult?{
        val client = OkHttpClient.Builder()
            .readTimeout( 5, TimeUnit.SECONDS)
            .connectTimeout( 10, TimeUnit.SECONDS)
            .build()
        val request = Request.Builder()
            .url(String.format(BOOK_JSON_URL, q))
            .build()
        try{
            val response =client.newCall(request).execute()
            val json = response.body?.string()
            val result = Gson().fromJson<SearchResult>(
                json, SearchResult::class.java)
            return result
        }catch (e : Exception){
            e.printStackTrace()
        }
        return null
    }
}