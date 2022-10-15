package com.example.qrcodescanner.ui.activities

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import com.example.qrcodescanner.R

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

  companion object {
    private const val CAMERA_PERMISSION_REQUEST_CODE = 123
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash)
    Handler().postDelayed({
      checkForPermission()
    },2000)

  }

  private fun checkForPermission() {
    if (ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.CAMERA
      ) == PackageManager.PERMISSION_GRANTED
    ) {
      goToMainActivity()
    } else {
      requestThePermission()
    }
  }

  private fun requestThePermission() {
    ActivityCompat.requestPermissions(
      this, arrayOf(Manifest.permission.CAMERA),
      CAMERA_PERMISSION_REQUEST_CODE
    )
  }

  override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
  ) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)

    if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
      if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
        goToMainActivity()
      } else if (isUserPermanentlyDenied()) {
        showGoToAppSettingDialog()
      } else {
        requestThePermission()
      }
    }
  }

  private fun showGoToAppSettingDialog() {
    AlertDialog.Builder(this)
      .setTitle("Grant Permissions!!")
      .setMessage("We need camera permission to scan QR code.\nGo to App Setting and manage permission.")
      .setPositiveButton("Grant") { dialog, whitch ->
        goToAppSettings()
      }
      .setNegativeButton("Cancel") { dialog, whitch ->
        Toast.makeText(this, "We need permission for Start this Application", Toast.LENGTH_SHORT)
          .show()
      }
  }

  private fun goToAppSettings() {
    val intent = Intent(
      Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
      Uri.fromParts("package", packageName, null)
    )
    intent.addCategory(Intent.CATEGORY_DEFAULT)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    startActivity(intent)
  }

  private fun isUserPermanentlyDenied(): Boolean {
    return shouldShowRequestPermissionRationale(Manifest.permission.CAMERA).not()
  }

  private fun goToMainActivity() {
    startActivity(Intent(this, MainActivity::class.java))
    finish()
  }

  override fun onRestart() {
    super.onRestart()
    checkForPermission()
  }
}