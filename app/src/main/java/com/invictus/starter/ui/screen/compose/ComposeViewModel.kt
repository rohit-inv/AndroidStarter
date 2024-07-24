package com.invictus.starter.ui.screen.compose

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ComposeViewModel : ViewModel() {

    val count: MutableLiveData<Int> = MutableLiveData(0)

}