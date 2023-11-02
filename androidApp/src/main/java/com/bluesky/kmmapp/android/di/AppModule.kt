package com.bluesky.kmmapp.android.di

import android.app.Application
import com.bluesky.kmmapp.database.TranslateDatabase
import com.bluesky.kmmapp.translate.data.history.SqlDelightHistoryDataSource
import com.bluesky.kmmapp.translate.data.local.DatabaseDriverFactory
import com.bluesky.kmmapp.translate.data.remote.HttpClientFactory
import com.bluesky.kmmapp.translate.data.translate.KtorTranslateClient
import com.bluesky.kmmapp.translate.domain.history.HistoryDataSource
import com.bluesky.kmmapp.translate.domain.translate.Translate
import com.bluesky.kmmapp.translate.domain.translate.TranslateClient

import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient{
        return HttpClientFactory().create()
    }

    @Provides
    @Singleton
    fun provideTranslateClient(httpClient: HttpClient): TranslateClient {
        return KtorTranslateClient(httpClient)
    }

    @Provides
    @Singleton
    fun provideDatabaseDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).create()
    }

    @Provides
    @Singleton
    fun provideHistoryDataSource(driver: SqlDriver): HistoryDataSource {
        return SqlDelightHistoryDataSource(TranslateDatabase(driver))
    }

    @Provides
    @Singleton
    fun provideHistoryUseCase(
        client: TranslateClient,
        dataSource: HistoryDataSource
    ): Translate {
        return Translate(client, dataSource)
    }
}