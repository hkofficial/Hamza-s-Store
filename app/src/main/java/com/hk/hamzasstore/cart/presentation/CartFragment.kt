package com.hk.hamzasstore.cart.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hk.hamzasstore.R
import com.hk.hamzasstore.cart.model.Cart
import com.hk.hamzasstore.databinding.FragmentCartBinding


class CartFragment : Fragment() {


    private lateinit var binding: FragmentCartBinding
    private val cartViewModel: CartViewModel by viewModels()
    private val cartList = arrayListOf<Cart>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = setRecyclerAdapter(cartList)
        cartViewModel.getCartList().observe(viewLifecycleOwner, {
            if(!it.isNullOrEmpty()) {
                cartList.clear()
                cartList.addAll(it)
                adapter.notifyDataSetChanged()
            }
        })
    }

    private fun setRecyclerAdapter(cartList: ArrayList<Cart>): CartAdapter {
        binding.cartRv.layoutManager =
            LinearLayoutManager(context)
        val adapter = CartAdapter(cartList)
        binding.cartRv.adapter = adapter
        return adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CartFragment()
    }
}