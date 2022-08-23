package com.techniquesmyanmar.fetchdatashowinmultirecycler.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.techniquesmyanmar.fetchdatashowinmultirecycler.model.MainCategory
import com.techniquesmyanmar.fetchdatashowinmultirecycler.model.MainCategoryX
import com.techniquesmyanmar.fetchdatashowinmultirecycler.repository.CategoryRepository
import kotlinx.coroutines.launch

class CategoryViewModel(val repository: CategoryRepository) : ViewModel() {
    init {
        viewModelScope.launch {
            repository.getCategoryData()
        }
    }

    val data : LiveData<MainCategory>
    get() = repository.data
}