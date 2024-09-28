package com.github.boodyahmedhamdy.domain.models

import com.github.boodyahmedhamdy.data.remote.dtos.CategoryDTO

data class Category(
    val id: String = "",
    val title: String = "",
    val imageUrl: String = "",
    val description: String = ""
)

fun Category.toDTO(): CategoryDTO {
    return CategoryDTO(
        idCategory = id,
        strCategory = title,
        strCategoryThumb = imageUrl,
        strCategoryDescription = description
    )
}

fun Category.fromDTO(dto: CategoryDTO): Category {
    return Category(
        id = dto.idCategory,
        title = dto.strCategory,
        imageUrl = dto.strCategoryThumb,
        description = dto.strCategoryDescription
    )
}

fun CategoryDTO.toModel(): Category {
    return Category(
        id = idCategory,
        title = strCategory,
        imageUrl = strCategoryThumb,
        description = strCategoryDescription
    )
}
