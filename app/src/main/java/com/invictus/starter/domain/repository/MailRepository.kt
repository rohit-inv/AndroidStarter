package com.invictus.starter.domain.repository

import com.invictus.starter.domain.model.MailModel
import com.invictus.starter.ui.recycler_utils.RModel

interface MailRepository {


    suspend fun getHomePage(): List<RModel>

    suspend fun getAllMail(): List<MailModel>
    suspend fun getMailById(id: Int): MailModel?

    suspend fun composeMail(mailModel: MailModel)
}