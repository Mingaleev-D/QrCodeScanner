package com.example.qrcodescanner.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.qrcodescanner.databinding.FragmentScannedHistoryBinding

class ScannedHistoryFragment : Fragment() {
  private var mBinding: FragmentScannedHistoryBinding? = null
  private val binding get() = mBinding!!

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    mBinding = FragmentScannedHistoryBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onDestroy() {
    super.onDestroy()
    mBinding = null
  }

  companion object {
    fun newInstance(): ScannedHistoryFragment = ScannedHistoryFragment()
  }


}