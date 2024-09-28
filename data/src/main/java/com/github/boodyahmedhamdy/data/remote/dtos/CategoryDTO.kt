package com.github.boodyahmedhamdy.data.remote.dtos


import com.google.gson.annotations.SerializedName

data class CategoryDTO(
    @SerializedName("idCategory")
    val idCategory: String = "",
    @SerializedName("strCategory")
    val strCategory: String = "",
    @SerializedName("strCategoryThumb")
    val strCategoryThumb: String = "",
    @SerializedName("strCategoryDescription")
    val strCategoryDescription: String = ""
)


