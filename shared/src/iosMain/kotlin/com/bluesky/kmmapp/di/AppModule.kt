package com.bluesky.kmmapp.di

import com.bluesky.kmmapp.database.TranslateDatabase
import com.bluesky.kmmapp.translate.data.history.SqlDelightHistoryDataSource
import com.bluesky.kmmapp.translate.data.local.DatabaseDriverFactory
import com.bluesky.kmmapp.translate.data.remote.HttpClientFactory
import com.bluesky.kmmapp.translate.data.translate.KtorTranslateClient
import com.bluesky.kmmapp.translate.domain.history.HistoryDataSource
import com.bluesky.kmmapp.translate.domain.translate.Translate
import com.bluesky.kmmapp.translate.domain.translate.TranslateClient

class AppModule {

    val historyDataSource: HistoryDataSource by lazy {
        SqlDelightHistoryDataSource(
            TranslateDatabase(
                DatabaseDriverFactory().create()
            )
        )
    }

    private val translateClient: TranslateClient by lazy {
        KtorTranslateClient(
            HttpClientFactory().create()
        )
    }

    val translateUseCase: Translate by lazy {
        Translate(translateClient, historyDataSource)
    }
}