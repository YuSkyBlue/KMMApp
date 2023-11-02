package com.bluesky.kmmapp.translate.data.history

import com.bluesky.kmmapp.translate.domain.history.HistoryItem
import database.HistoryEntity

fun HistoryEntity.toHistoryItem(): HistoryItem {
    return HistoryItem(
        id = id,
        fromLanguageCode = fromLanguageCode,
        fromText = fromText,
        toLanguageCode= toLanguageCode,
        toText = toText
    )
}