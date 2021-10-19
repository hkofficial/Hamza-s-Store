package com.hk.hamzasstore.commons.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hk.hamzasstore.R
import com.hk.hamzasstore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val pagerAdapter = TabsPagerAdapter(this)
        binding.pager.adapter = pagerAdapter

        handleBottomBarClick()
    }

    private fun handleBottomBarClick() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    binding.pager.currentItem = 0
                    true
                }
                R.id.cart -> {
                    binding.pager.currentItem = 1
                    true
                }
                else -> false
            }
        }
    }
}