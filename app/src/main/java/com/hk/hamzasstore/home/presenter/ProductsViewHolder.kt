package com.hk.hamzasstore.home.presenter

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hk.hamzasstore.commons.models.Product
import com.hk.hamzasstore.databinding.ProductListItemBinding
import com.hk.hamzasstore.product_detail.presenter.ProductDetailActivity

class ProductsViewHolder(
    private val binding: ProductListItemBinding,
    private val productsViewModel: ProductsViewModel
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(product: Product) {

        binding.product = product

        Glide.with(binding.root.context).load(product.image).into(binding.productImage)

        binding.root.setOnClickListener {
            val intent = Intent(binding.root.context, ProductDetailActivity::class.java)
            intent.putExtra("productId", product.id)
            binding.root.context.startActivity(intent)
        }

        binding.addToCartButton.setOnClickListener{
            productsViewModel.addProductToCart(adapterPosition)
        }
    }
}