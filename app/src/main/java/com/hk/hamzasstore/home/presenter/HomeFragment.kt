package com.hk.hamzasstore.home.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.hk.hamzasstore.R
import com.hk.hamzasstore.commons.utilities.OnCompleteListener
import com.hk.hamzasstore.commons.utilities.ResponseState
import com.hk.hamzasstore.databinding.FragmentHomeBinding
import com.hk.hamzasstore.commons.models.Product
import com.hk.hamzasstore.home.utility.GirdSpacingItemDecoration


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val productsViewModel: ProductsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = setRecyclerAdapter()

        productsViewModel.getProducts(object : OnCompleteListener<ArrayList<Product>> {
            override fun onSuccess(response: ArrayList<Product>?) {
                binding.shimmerViewContainer.stopShimmer()
                binding.shimmerViewContainer.visibility = View.GONE
                adapter.notifyDataSetChanged()
            }

            override fun onFailure(errorType: ResponseState.ErrorType?, errorMessage: String?) {
                if (isAdded)
                    Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show();
            }

        })
    }

    private fun setRecyclerAdapter(): ProductsAdapter {
        binding.productsRv.layoutManager =
            GridLayoutManager(context,2, GridLayoutManager.VERTICAL,false)
        binding.productsRv.addItemDecoration(GirdSpacingItemDecoration(2, 0, false, 0))
        val adapter = ProductsAdapter(productsViewModel)
        binding.productsRv.adapter = adapter
        return adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment()
    }
}