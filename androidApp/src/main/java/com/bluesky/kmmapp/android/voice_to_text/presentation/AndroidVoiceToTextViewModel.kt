package com.bluesky.kmmapp.android.voice_to_text.presentation

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bluesky.kmmapp.voice_to_text.domain.VoiceToTextParser
import com.bluesky.kmmapp.voice_to_text.presentation.VoiceToTextEvent
import com.bluesky.kmmapp.voice_to_text.presentation.VoiceToTextViewModel

@HiltViewModel
class AndroidVoiceToTextViewModel @Inject constructor(
    private val parser: VoiceToTextParser
): ViewModel() {

    private val viewModel by lazy {
        VoiceToTextViewModel(
            parser = parser,
            coroutineScope = viewModelScope
        )
    }

    val state = viewModel.state

    fun onEvent(event: VoiceToTextEvent) {
        viewModel.onEvent(event)
    }
}