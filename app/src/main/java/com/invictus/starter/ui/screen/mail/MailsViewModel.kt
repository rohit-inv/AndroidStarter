package com.invictus.starter.ui.screen.mail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invictus.starter.data.reposiotory.MailRepositoryImpl
import com.invictus.starter.domain.model.MailModel
import com.invictus.starter.domain.repository.MailRepository
import kotlinx.coroutines.launch

class MailsViewModel : ViewModel() {
    private val mailRepository: MailRepository = MailRepositoryImpl.INSTANCE


    private val _mails = MutableLiveData<List<MailModel>>()
    val mails: LiveData<List<MailModel>> = _mails

    init {
        loadMails()
    }

    private fun loadMails() {
        viewModelScope.launch {
            _mails.postValue(mailRepository.getAllMail())
        }
    }


}