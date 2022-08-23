package com.techniquesmyanmar.fetchdatashowinmultirecycler.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.techniquesmyanmar.fetchdatashowinmultirecycler.databinding.ItemListBinding
import com.techniquesmyanmar.fetchdatashowinmultirecycler.model.MainCategory
import com.techniquesmyanmar.fetchdatashowinmultirecycler.model.MainCategoryX

class CategoryAdapter(private val categoryList: List<MainCategoryX>)
    : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
        class CategoryViewHolder(private val binding: ItemListBinding) :
            RecyclerView.ViewHolder(binding.root){
                fun bind(item: MainCategoryX){
                    binding.tvName.text = item.name
                    binding.ivPhoto.load(
                        Uri.parse(item.url)
                    ){
                        crossfade(1000)
                        crossfade(true)
                        transformations(CircleCropTransformation())
                    }

                    var productAdapter = ProductAdapter(item.productListBuyers)
                    binding.rvProduct.setHasFixedSize(true)
                    binding.rvProduct.layoutManager = LinearLayoutManager(itemView.context,
                        LinearLayoutManager.HORIZONTAL,false)
                    binding.rvProduct.adapter = productAdapter
                }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categoryList.get(position))
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

}