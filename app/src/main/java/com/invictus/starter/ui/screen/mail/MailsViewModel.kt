package com.invictus.starter.ui.screen.mail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invictus.starter.di.AppModule
import com.invictus.starter.domain.repository.MailRepository
import com.invictus.starter.ui.recycler_utils.RecyclerModel
import kotlinx.coroutines.launch

class MailsViewModel : ViewModel() {
    private val mailRepository: MailRepository = AppModule.mailRepository


    private val _mails = MutableLiveData<List<RecyclerModel>>()
    val mails: LiveData<List<RecyclerModel>> = _mails

    init {
        loadMails()
    }

    private fun loadMails() {
        viewModelScope.launch {
            _mails.postValue(mailRepository.getHomePage())
        }
    }


}