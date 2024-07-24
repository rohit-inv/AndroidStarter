package com.invictus.starter.domain.repository

import com.invictus.starter.domain.model.MailModel

interface MailRepository {

    suspend fun getAllMail(): List<MailModel>

    suspend fun composeMail(mailModel: MailModel)
}