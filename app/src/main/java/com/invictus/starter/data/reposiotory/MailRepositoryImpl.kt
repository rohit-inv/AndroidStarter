package com.invictus.starter.data.reposiotory

import com.invictus.starter.data.data_source.FakeMailDataSource
import com.invictus.starter.domain.model.MailModel
import com.invictus.starter.domain.repository.MailRepository

class MailRepositoryImpl(
    private val mailDataSource: FakeMailDataSource
) : MailRepository {

    override suspend fun getAllMail(): List<MailModel> {
        return mailDataSource.getAllMails()
    }

    override suspend fun composeMail(mailModel: MailModel) {
        mailDataSource.composeMail(mailModel)
    }

    companion object {
        val INSTANCE by lazy { MailRepositoryImpl(FakeMailDataSource) }
    }
}