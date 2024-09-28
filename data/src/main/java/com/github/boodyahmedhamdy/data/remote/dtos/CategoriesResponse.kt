package com.github.boodyahmedhamdy.data.remote.dtos


import com.google.gson.annotations.SerializedName

data class CategoriesResponse(
    @SerializedName("categories")
    val categories: List<CategoryDTO> = listOf()
)