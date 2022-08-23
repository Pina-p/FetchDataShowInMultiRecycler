package com.techniquesmyanmar.fetchdatashowinmultirecycler.api

import com.techniquesmyanmar.fetchdatashowinmultirecycler.model.MainCategory
import com.techniquesmyanmar.fetchdatashowinmultirecycler.model.MainCategoryX
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("multirec")
    suspend fun getCategoryData(): Response<MainCategory>
}