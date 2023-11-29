package com.vlassapplication.app.modules.androidlargefive.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.vlassapplication.app.R
import com.vlassapplication.app.appcomponents.base.BaseActivity
import com.vlassapplication.app.databinding.ActivityAndroidLargeFiveBinding
import com.vlassapplication.app.modules.androidlargefive.`data`.viewmodel.AndroidLargeFiveVM
import com.vlassapplication.app.modules.androidlargeone.ui.AndroidLargeOneActivity
import kotlin.String
import kotlin.Unit

class AndroidLargeFiveActivity :
    BaseActivity<ActivityAndroidLargeFiveBinding>(R.layout.activity_android_large_five) {
  private val viewModel: AndroidLargeFiveVM by viewModels<AndroidLargeFiveVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.androidLargeFiveVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btn.setOnClickListener {
      val destIntent = AndroidLargeOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageClose.setOnClickListener {
      val destIntent = AndroidLargeOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "ANDROID_LARGE_FIVE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AndroidLargeFiveActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
