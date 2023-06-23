package com.example.myapplication.data.model

import com.google.gson.annotations.SerializedName

data class CategoryDetailModel(
    @SerializedName("id")
    val id: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("value")
    val value: String?
)