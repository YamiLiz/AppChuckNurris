package com.example.myapplication.data.model

import com.google.gson.annotations.SerializedName

data class DetailCategoryResponse (
    @SerializedName("total")
    val total: Int,
    @SerializedName("result")
    val result: ArrayList<CategoryDetailModel>
)
