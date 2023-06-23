package com.example.myapplication.domain

import com.example.myapplication.data.model.CategoryDetailModel
import com.example.myapplication.data.model.repository.CategoriesRepository
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: CategoriesRepository
) {
    suspend operator fun invoke(): List<String> = repository.getCategories()

    suspend fun searchCategories(category : String): CategoryDetailModel? = repository.getDetailCategory(category)
}