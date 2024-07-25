package com.invictus.starter.data.reposiotory

import com.invictus.starter.data.data_source.FakeMailDataSource
import com.invictus.starter.domain.model.MailModel
import com.invictus.starter.domain.repository.MailRepository
import com.invictus.starter.ui.recycler_utils.Header
import com.invictus.starter.ui.recycler_utils.RecyclerModel

class MailRepositoryImpl(
    private val mailDataSource: FakeMailDataSource
) : MailRepository {

    override suspend fun getHomePage(): List<RecyclerModel> {
        return listOf(Header("Header")) + getAllMail()
    }

    override suspend fun getAllMail(): List<MailModel> {
        return mailDataSource.getAllMails()
    }

    override suspend fun composeMail(mailModel: MailModel) {
        mailDataSource.composeMail(mailModel)
    }

    override suspend fun getMailById(id: Int): MailModel? {
        return mailDataSource.getMailById(id)
    }

}