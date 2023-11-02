package com.bluesky.kmmapp.translate.domain.history

import com.bluesky.kmmapp.core.domain.util.CommonFlow

interface HistoryDataSource {
    fun getHistory(): CommonFlow<List<HistoryItem>>
    suspend fun insertHistoryItem(item: HistoryItem)
}