package com.techniquesmyanmar.fetchdatashowinmultirecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.techniquesmyanmar.fetchdatashowinmultirecycler.adapter.CategoryAdapter
import com.techniquesmyanmar.fetchdatashowinmultirecycler.api.RetrofitInstance
import com.techniquesmyanmar.fetchdatashowinmultirecycler.api.RetrofitInterface
import com.techniquesmyanmar.fetchdatashowinmultirecycler.databinding.ActivityMainBinding
import com.techniquesmyanmar.fetchdatashowinmultirecycler.model.MainCategory
import com.techniquesmyanmar.fetchdatashowinmultirecycler.model.MainCategoryX
import com.techniquesmyanmar.fetchdatashowinmultirecycler.model.ProductBuyers
import com.techniquesmyanmar.fetchdatashowinmultirecycler.repository.CategoryRepository
import com.techniquesmyanmar.fetchdatashowinmultirecycler.viewmodel.CategoryViewModel
import com.techniquesmyanmar.fetchdatashowinmultirecycler.viewmodel.CategoryViewModelFactory


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : CategoryViewModel
    private lateinit var binding : ActivityMainBinding
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var categoryList: List<MainCategory>
    private lateinit var list : List<ProductBuyers>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val service = RetrofitInstance.getInstance().create(RetrofitInterface::class.java)
        val repository = CategoryRepository(service)
        viewModel = ViewModelProvider(this,CategoryViewModelFactory(repository)).get(CategoryViewModel::class.java)
        viewModel.data.observe(this) {
          //  Log.d("test", "x : ${categoryList}")
            binding.rvFirst.setHasFixedSize(true)
            binding.rvFirst.layoutManager = LinearLayoutManager(this)

            categoryAdapter = CategoryAdapter(it.mainCategory)
            binding.rvFirst.adapter = categoryAdapter

        }



    }

}