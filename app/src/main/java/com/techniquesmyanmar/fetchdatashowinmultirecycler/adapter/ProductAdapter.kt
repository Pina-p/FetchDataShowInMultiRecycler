package com.techniquesmyanmar.fetchdatashowinmultirecycler.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.techniquesmyanmar.fetchdatashowinmultirecycler.databinding.ItemListBinding
import com.techniquesmyanmar.fetchdatashowinmultirecycler.databinding.ProductItemListBinding
import com.techniquesmyanmar.fetchdatashowinmultirecycler.model.ProductBuyers

class ProductAdapter(private val productList: List<ProductBuyers>)
    : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    class ProductViewHolder(private val binding: ProductItemListBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(item: ProductBuyers){
            binding.tvName.text = item.name
            binding.ivPhoto.load(
                Uri.parse(item.url)
            ){
                crossfade(1000)
                crossfade(true)
                transformations(CircleCropTransformation())
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ProductItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }


    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductAdapter.ProductViewHolder, position: Int) {
        holder.bind(productList.get(position))
    }

}