package com.invictus.starter.ui.screen.mail_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invictus.starter.di.AppModule
import com.invictus.starter.domain.repository.MailRepository
import kotlinx.coroutines.launch

class MailDetailsViewModel : ViewModel() {
    private val mailRepository: MailRepository = AppModule.mailRepository


    private fun loadMailById(id: Int) {
        viewModelScope.launch {

        }
    }


}