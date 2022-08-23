package com.techniquesmyanmar.fetchdatashowinmultirecycler.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.techniquesmyanmar.fetchdatashowinmultirecycler.repository.CategoryRepository

class CategoryViewModelFactory(private val repository: CategoryRepository) :
ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CategoryViewModel(repository) as T
    }
}