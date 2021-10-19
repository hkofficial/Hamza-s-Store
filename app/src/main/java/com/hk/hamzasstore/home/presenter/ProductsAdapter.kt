package com.hk.hamzasstore.home.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hk.hamzasstore.databinding.ProductListItemBinding

class ProductsAdapter(private val productsViewModel: ProductsViewModel) :
    RecyclerView.Adapter<ProductsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductsViewHolder(
            ProductListItemBinding.inflate(
                layoutInflater,
                parent,
                false
            ),
            productsViewModel
        )
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(productsViewModel.products[position])
    }

    override fun getItemCount(): Int {
        return productsViewModel.products.size
    }

}