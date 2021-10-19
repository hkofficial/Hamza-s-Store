package com.hk.hamzasstore.product_detail.presenter

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.hk.hamzasstore.R
import com.hk.hamzasstore.commons.models.Product
import com.hk.hamzasstore.commons.utilities.OnCompleteListener
import com.hk.hamzasstore.commons.utilities.ResponseState
import com.hk.hamzasstore.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {
    private var productId: Int? = -1
    private lateinit var binding: ActivityProductDetailBinding
    private val productDetailViewModel: ProductDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_detail)
        getDataFromIntent()
        fetchProduct()

        binding.closeButton.setOnClickListener{
            finish()
        }
    }

    private fun fetchProduct() {
        productId?.let {
            productDetailViewModel.getProductDetail(it, object : OnCompleteListener<Product> {
                override fun onSuccess(response: Product?) {
                    response?.let { it ->
                        hideLoader()
                        binding.product = it
                        Glide.with(this@ProductDetailActivity)
                            .load(it.image)
                            .into(binding.productImage)
                    }
                }

                override fun onFailure(errorType: ResponseState.ErrorType?, errorMessage: String?) {
                    Toast.makeText(this@ProductDetailActivity, errorMessage, Toast.LENGTH_SHORT)
                        .show()
                    finish()
                }

            })
        }
    }

    private fun hideLoader() {
        binding.shimmerViewContainer.stopShimmer()
        binding.shimmerViewContainer.visibility = View.GONE
        binding.detailLayout.visibility = View.VISIBLE
    }

    private fun getDataFromIntent() {
        if (intent.hasExtra("productId"))
            productId = intent.getIntExtra("productId", 0)
        else {
            Toast.makeText(this, "Could not find product info", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        productDetailViewModel.cancelCalls()
    }
}