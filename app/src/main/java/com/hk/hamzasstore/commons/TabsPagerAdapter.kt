package com.hk.hamzasstore.commons

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hk.hamzasstore.home.presenter.HomeFragment


private const val NUM_PAGES = 2

class TabsPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        when(position){
            1->{
                return HomeFragment.newInstance()
            }
            else ->{
                return HomeFragment.newInstance()
            }
        }
    }
}