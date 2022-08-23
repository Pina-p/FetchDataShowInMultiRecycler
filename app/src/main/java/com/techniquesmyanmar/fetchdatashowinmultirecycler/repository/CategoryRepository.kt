package com.techniquesmyanmar.fetchdatashowinmultirecycler.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.techniquesmyanmar.fetchdatashowinmultirecycler.api.RetrofitInterface
import com.techniquesmyanmar.fetchdatashowinmultirecycler.model.MainCategory
import com.techniquesmyanmar.fetchdatashowinmultirecycler.model.MainCategoryX


class CategoryRepository (private val service: RetrofitInterface) {
    private val categoryLiveData = MutableLiveData<MainCategory>()
    val data : LiveData<MainCategory>
        get() = categoryLiveData

    suspend fun getCategoryData(){
        val  result = service.getCategoryData()
        Log.d("data", "getCategoryData r: ${result}")
        if(result.body() != null){
            Log.d("data", "getCategoryData: ${result.body()}")
            categoryLiveData.postValue(result.body()!!)
        }else{
            Log.d("data", "getCategoryData: ${result.body()}")
        }
    }
}