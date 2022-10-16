package com.example.qrcodescanner.ui.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.qrcodescanner.ui.fragments.QrScannerFragment
import com.example.qrcodescanner.ui.fragments.ScannedHistoryFragment

/**
 * @author : Mingaleev D
 * @data : 16/10/2022
 */

class MainPagerAdapter(var fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

  override fun getCount() = 3

  override fun getItem(position: Int): Fragment {
    return when (position) {
      0 -> QrScannerFragment.newInstance()
      1 -> ScannedHistoryFragment.newInstance()
      2 -> ScannedHistoryFragment.newInstance()
      else -> QrScannerFragment.newInstance()
    }
  }
}