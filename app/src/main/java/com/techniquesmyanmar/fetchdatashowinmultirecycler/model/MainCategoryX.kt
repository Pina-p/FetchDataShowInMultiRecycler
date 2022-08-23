package com.techniquesmyanmar.fetchdatashowinmultirecycler.model

data class MainCategoryX(
    val id: Int,
    val mainCategoryId: Int,
    val name: String,
    val productListBuyers: List<ProductBuyers>,
    val url: String
)