package com.vlassapplication.app.modules.androidlargeone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.viewModels
import com.vlassapplication.app.R
import com.vlassapplication.app.appcomponents.base.BaseActivity
import com.vlassapplication.app.databinding.ActivityAndroidLargeOneBinding
import com.vlassapplication.app.modules.androidlargefive.ui.AndroidLargeFiveActivity
import com.vlassapplication.app.modules.androidlargeone.`data`.model.ListoneRowModel
import com.vlassapplication.app.modules.androidlargeone.`data`.viewmodel.AndroidLargeOneVM
import com.vlassapplication.app.modules.androidlargethree.ui.AndroidLargeThreeActivity
import com.vlassapplication.app.modules.androidlargetwo.ui.AndroidLargeTwoActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class AndroidLargeOneActivity :
    BaseActivity<ActivityAndroidLargeOneBinding>(R.layout.activity_android_large_one) {
  private val viewModel: AndroidLargeOneVM by viewModels<AndroidLargeOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listoneAdapter = ListoneAdapter(viewModel.listoneList.value?:mutableListOf())
    binding.recyclerListone.adapter = listoneAdapter
    listoneAdapter.setOnItemClickListener(
    object : ListoneAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ListoneRowModel) {
        onClickRecyclerListone(view, position, item)
      }
    }
    )
    viewModel.listoneList.observe(this) {
      listoneAdapter.updateData(it)
    }
    binding.androidLargeOneVM = viewModel
    Handler(Looper.getMainLooper()).postDelayed( {
      val destIntent = AndroidLargeTwoActivity.getIntent(this, null)
      startActivity(destIntent)
      finish()
      }, 3000)
    }

    override fun setUpClicks(): Unit {
      binding.frameMyBambax1.setOnClickListener {
        val destIntent = AndroidLargeThreeActivity.getIntent(this, null)
        startActivity(destIntent)
      }
      binding.frameMyBambax.setOnClickListener {
        val destIntent = AndroidLargeTwoActivity.getIntent(this, null)
        startActivity(destIntent)
      }
      binding.btnBtnAdd.setOnClickListener {
        val destIntent = AndroidLargeFiveActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }

    fun onClickRecyclerListone(
      view: View,
      position: Int,
      item: ListoneRowModel
    ): Unit {
      when(view.id) {
      }
    }

    companion object {
      const val TAG: String = "ANDROID_LARGE_ONE_ACTIVITY"


      fun getIntent(context: Context, bundle: Bundle?): Intent {
        val destIntent = Intent(context, AndroidLargeOneActivity::class.java)
        destIntent.putExtra("bundle", bundle)
        return destIntent
      }
    }
  }
