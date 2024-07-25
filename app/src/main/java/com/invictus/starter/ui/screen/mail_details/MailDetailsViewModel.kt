package com.invictus.starter.ui.screen.mail_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invictus.starter.di.AppModule
import com.invictus.starter.domain.model.MailModel
import com.invictus.starter.domain.repository.MailRepository
import kotlinx.coroutines.launch


data class MailDetailsUiState(
    val loading: Boolean = false,
    val error: String? = null,
    val mail: MailModel? = null
)

class MailDetailsViewModel : ViewModel() {
    private val mailRepository: MailRepository = AppModule.mailRepository

    private val _mail = MutableLiveData(MailDetailsUiState())
    val mail: LiveData<MailDetailsUiState> = _mail


    fun loadMailById(id: Int) {
        _mail.postValue(
            MailDetailsUiState(
                loading = true
            )
        )
        viewModelScope.launch {
            val model = mailRepository.getMailById(id)
            kotlinx.coroutines.delay(1000)
            _mail.postValue(
                MailDetailsUiState(
                    mail = model,
                    error = if (model == null) "Error fetching mail" else null
                )
            )
        }
    }


}