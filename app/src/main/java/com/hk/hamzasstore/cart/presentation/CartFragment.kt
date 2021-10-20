package com.hk.hamzasstore.cart.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hk.hamzasstore.R
import com.hk.hamzasstore.cart.model.Cart
import com.hk.hamzasstore.databinding.FragmentCartBinding
import com.hk.hamzasstore.home.presenter.ProductsAdapter
import com.hk.hamzasstore.home.utility.GirdSpacingItemDecoration


class CartFragment : Fragment() {


    private lateinit var binding: FragmentCartBinding

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
        val adapter = setRecyclerAdapter()
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerAdapter(): CartAdapter {
        binding.cartRv.layoutManager =
            LinearLayoutManager(context)
        val cartItems = arrayListOf<Cart>()
        cartItems.add(Cart(1,"Dalda",200.0,"",2))
        cartItems.add(Cart(2,"Tullo",360.0,"",3))
        cartItems.add(Cart(3,"Nestle pure life",480.0,"",1))
        cartItems.add(Cart(4,"Dalda",168.1,"",8))
        val adapter = CartAdapter(cartItems)
        binding.cartRv.adapter = adapter
        return adapter
    }
    companion object {
        @JvmStatic
        fun newInstance() =
            CartFragment()
    }
}