package com.hk.hamzasstore.commons.presenter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hk.hamzasstore.cart.presentation.CartFragment
import com.hk.hamzasstore.home.presenter.HomeFragment


private const val NUM_PAGES = 2

class TabsPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        when(position){
            0->{
                return HomeFragment.newInstance()
            }
            else ->{
                return CartFragment.newInstance()
            }
        }
    }
}