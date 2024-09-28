package com.github.boodyahmedhamdy.data.remote.dtos


import com.google.gson.annotations.SerializedName

data class MealsResponse(
    @SerializedName("meals")
    val meals: List<MealDTO> = listOf()
)