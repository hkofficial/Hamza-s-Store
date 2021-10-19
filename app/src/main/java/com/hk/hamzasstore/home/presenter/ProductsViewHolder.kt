package com.hk.hamzasstore.home.presenter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hk.hamzasstore.databinding.ProductListItemBinding
import com.hk.hamzasstore.home.Product

class ProductsViewHolder(
    val binding: ProductListItemBinding,
    productsViewModel: ProductsViewModel
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(product: Product) {
        binding.productName.text = product.title
        binding.productPrice.text = product.price.toString()
        Glide.with(binding.root.context).load(product.image).into(binding.productImage)
    }
}