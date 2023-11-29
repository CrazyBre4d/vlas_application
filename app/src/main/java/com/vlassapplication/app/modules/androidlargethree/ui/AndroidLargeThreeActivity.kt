package com.vlassapplication.app.modules.androidlargethree.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.vlassapplication.app.R
import com.vlassapplication.app.appcomponents.base.BaseActivity
import com.vlassapplication.app.databinding.ActivityAndroidLargeThreeBinding
import com.vlassapplication.app.modules.androidlargeone.ui.AndroidLargeOneActivity
import com.vlassapplication.app.modules.androidlargethree.`data`.viewmodel.AndroidLargeThreeVM
import com.vlassapplication.app.modules.androidlargetwo.ui.AndroidLargeTwoActivity
import kotlin.String
import kotlin.Unit

class AndroidLargeThreeActivity :
    BaseActivity<ActivityAndroidLargeThreeBinding>(R.layout.activity_android_large_three) {
  private val viewModel: AndroidLargeThreeVM by viewModels<AndroidLargeThreeVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.androidLargeThreeVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.frameMyBambax.setOnClickListener {
      val destIntent = AndroidLargeTwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.frameSuppliers.setOnClickListener {
      val destIntent = AndroidLargeOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "ANDROID_LARGE_THREE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AndroidLargeThreeActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
