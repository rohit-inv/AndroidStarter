package com.invictus.starter.ui.screen.compose

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.invictus.starter.di.AppModule

class ComposeViewModel : ViewModel() {
    private val mainRepository = AppModule.mailRepository

    val count: MutableLiveData<Int> = MutableLiveData(0)


    fun composeMail(
        toName: String,
        subject: String,
        body: String
    ) {

    }

}