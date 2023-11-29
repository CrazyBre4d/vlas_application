package com.vlassapplication.app.modules.androidlargeone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vlassapplication.app.modules.androidlargeone.`data`.model.AndroidLargeOneModel
import com.vlassapplication.app.modules.androidlargeone.`data`.model.ListoneRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class AndroidLargeOneVM : ViewModel(), KoinComponent {
  val androidLargeOneModel: MutableLiveData<AndroidLargeOneModel> =
      MutableLiveData(AndroidLargeOneModel())

  var navArguments: Bundle? = null

  val listoneList: MutableLiveData<MutableList<ListoneRowModel>> = MutableLiveData(mutableListOf())
}
