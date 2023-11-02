package com.bluesky.kmmapp.translate.domain.translate

import com.bluesky.kmmapp.core.domain.language.Language

interface TranslateClient  {
    suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ) : String
}