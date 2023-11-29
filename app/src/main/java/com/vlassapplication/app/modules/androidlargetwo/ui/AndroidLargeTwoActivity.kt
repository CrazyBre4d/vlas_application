package com.vlassapplication.app.modules.androidlargetwo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.vlassapplication.app.R
import com.vlassapplication.app.appcomponents.base.BaseActivity
import com.vlassapplication.app.databinding.ActivityAndroidLargeTwoBinding
import com.vlassapplication.app.modules.androidlargeone.ui.AndroidLargeOneActivity
import com.vlassapplication.app.modules.androidlargesix.ui.AndroidLargeSixActivity
import com.vlassapplication.app.modules.androidlargethree.ui.AndroidLargeThreeActivity
import com.vlassapplication.app.modules.androidlargetwo.`data`.viewmodel.AndroidLargeTwoVM
import kotlin.String
import kotlin.Unit

class AndroidLargeTwoActivity :
    BaseActivity<ActivityAndroidLargeTwoBinding>(R.layout.activity_android_large_two) {
  private val viewModel: AndroidLargeTwoVM by viewModels<AndroidLargeTwoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.androidLargeTwoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.frameSuppliers.setOnClickListener {
      val destIntent = AndroidLargeOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnOne.setOnClickListener {
      val destIntent = AndroidLargeSixActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.frameMyBambax1.setOnClickListener {
      val destIntent = AndroidLargeThreeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "ANDROID_LARGE_TWO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AndroidLargeTwoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
