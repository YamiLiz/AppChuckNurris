package com.example.myapplication.data.network

import com.example.myapplication.data.model.CategoriesResponse
import com.example.myapplication.data.model.CategoryDetailModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("categories")
    suspend fun getCategories() : Response<CategoriesResponse>

    @GET("random")
    suspend fun searchCategory(
        @Query("category") query: String
    ) : Response<CategoryDetailModel>
}