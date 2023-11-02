package com.bluesky.kmmapp.core.presentation

import com.bluesky.kmmapp.core.domain.language.Language

expect class UiLanguage {
    val language: Language
    companion object {
        fun byCode(langCode: String):UiLanguage
        val allLanguages: List<UiLanguage>
    }
}