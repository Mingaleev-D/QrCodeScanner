package com.example.qrcodescanner.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.qrcodescanner.R
import com.example.qrcodescanner.databinding.FragmentQrScannerBinding


class QrScannerFragment : Fragment() {
  private var mBinding: FragmentQrScannerBinding? = null
  private val binding get() = mBinding!!


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    mBinding = FragmentQrScannerBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onDestroy() {
    super.onDestroy()
    mBinding = null
  }

  companion object {
    fun newInstance(): QrScannerFragment = QrScannerFragment()
  }


}