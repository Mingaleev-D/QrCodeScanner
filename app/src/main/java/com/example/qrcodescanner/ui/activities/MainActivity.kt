package com.example.qrcodescanner.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.qrcodescanner.R
import com.example.qrcodescanner.databinding.ActivityMainBinding
import com.example.qrcodescanner.ui.adapter.MainPagerAdapter

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    setViewPagerAdapter()
    setBottomNavigation()
    setViewPagerListener()
  }

  private fun setViewPagerListener() {
    binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
      override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        // TODO("Not yet implemented")
      }

      override fun onPageSelected(position: Int) {
        binding.bottomNavigationView.selectedItemId = when (position) {
          0 -> R.id.scanMenuId
          1 -> R.id.recentScannedMenuId
          2 -> R.id.favoritesMenuId
          else -> R.id.scanMenuId
        }
      }

      override fun onPageScrollStateChanged(state: Int) {
        //TODO("Not yet implemented")
      }

    })
  }

  private fun setBottomNavigation() {
    binding.bottomNavigationView.setOnNavigationItemSelectedListener {
      when (it.itemId) {
        R.id.scanMenuId -> binding.viewPager.currentItem = 0
        R.id.recentScannedMenuId -> binding.viewPager.currentItem = 1
        R.id.favoritesMenuId -> binding.viewPager.currentItem = 2
      }
      return@setOnNavigationItemSelectedListener true
    }
  }

  private fun setViewPagerAdapter() {
    binding.viewPager.adapter = MainPagerAdapter(supportFragmentManager)
  }
}