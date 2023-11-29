package com.vlassapplication.app.modules.androidlargetwo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vlassapplication.app.modules.androidlargetwo.`data`.model.AndroidLargeTwoModel
import org.koin.core.KoinComponent

class AndroidLargeTwoVM : ViewModel(), KoinComponent {
  val androidLargeTwoModel: MutableLiveData<AndroidLargeTwoModel> =
      MutableLiveData(AndroidLargeTwoModel())

  var navArguments: Bundle? = null
}
