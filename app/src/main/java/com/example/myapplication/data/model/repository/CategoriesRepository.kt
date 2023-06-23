package com.example.myapplication.data.model.repository

import com.example.myapplication.data.network.ApiClient
import com.example.myapplication.data.model.CategoryDetailModel
import javax.inject.Inject

class CategoriesRepository @Inject constructor(
    private val apiClient: ApiClient
) {

    suspend fun getCategories() : List<String>{
        return try{
            apiClient.getCategories().body() ?: emptyList()
        }
        catch(e : Exception){
            emptyList()
        }
    }

    suspend fun getDetailCategory(category: String): CategoryDetailModel?{
        return apiClient.searchCategory(category).body()
    }

}