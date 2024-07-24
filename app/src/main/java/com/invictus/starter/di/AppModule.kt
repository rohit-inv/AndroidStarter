package com.invictus.starter.di

import com.invictus.starter.data.data_source.FakeMailDataSource
import com.invictus.starter.data.reposiotory.MailRepositoryImpl
import com.invictus.starter.domain.repository.MailRepository

object AppModule {

    val mailRepository: MailRepository by lazy { MailRepositoryImpl(FakeMailDataSource) }

}