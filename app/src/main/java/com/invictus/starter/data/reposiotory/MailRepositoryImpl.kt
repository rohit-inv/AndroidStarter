package com.invictus.starter.data.reposiotory

import com.invictus.starter.data.data_source.FakeMailDataSource
import com.invictus.starter.domain.model.HeaderModel
import com.invictus.starter.domain.model.HorizontalListModel
import com.invictus.starter.domain.model.MailModel
import com.invictus.starter.domain.model.RecentMailModel
import com.invictus.starter.domain.repository.MailRepository
import com.invictus.starter.ui.recycler_utils.RecyclerModel

class MailRepositoryImpl(
    private val mailDataSource: FakeMailDataSource
) : MailRepository {

    override suspend fun getHomePage(): List<RecyclerModel> {
        val allMail = getAllMail()
        return listOf(
            HeaderModel("Recent Mails", 8F),
            HorizontalListModel(
                id = 1,
                recyclerModels = allMail.distinctBy { it.name },
                horizontalGapDp = 0F,
                verticalGapDp = 0F,
                noOfRows = 3
            ),
            HeaderModel("Recent Contact", 8F),
            HorizontalListModel(
                id = 1,
                recyclerModels = allMail.distinctBy { it.name }.map {
                    RecentMailModel(
                        name = it.name,
                        color = it.color
                    )
                },
                horizontalGapDp = 16F,
                verticalGapDp = 8F,
                noOfRows = 1
            ),
            HeaderModel("All Mails", 6F),
        ) + allMail
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