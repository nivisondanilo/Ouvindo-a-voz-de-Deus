package com.example.accessibility

import android.content.Context
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import com.example.i18n.AppLanguage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Locale

class TtsManager(context: Context) {
    private var tts: TextToSpeech? = null
    private var isReady = false

    private val _activeSpeechId = MutableStateFlow<String?>(null)
    val activeSpeechId: StateFlow<String?> = _activeSpeechId.asStateFlow()

    init {
        tts = TextToSpeech(context.applicationContext) { status ->
            isReady = status == TextToSpeech.SUCCESS
            if (isReady) {
                tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                    override fun onStart(utteranceId: String?) {
                        _activeSpeechId.value = utteranceId
                    }

                    override fun onDone(utteranceId: String?) {
                        if (_activeSpeechId.value == utteranceId) {
                            _activeSpeechId.value = null
                        }
                    }

                    @Deprecated("Deprecated in Java")
                    override fun onError(utteranceId: String?) {
                        if (_activeSpeechId.value == utteranceId) {
                            _activeSpeechId.value = null
                        }
                    }
                })
            }
        }
    }

    fun toggleSpeak(
        speechId: String,
        text: String,
        language: AppLanguage,
        speechRate: Float = 1.0f
    ) {
        if (_activeSpeechId.value == speechId) {
            stop()
            return
        }
        if (!isReady) return
        val locale = Locale.forLanguageTag(language.localeTag)
        tts?.language = locale
        tts?.setSpeechRate(speechRate.coerceIn(0.7f, 1.5f))
        _activeSpeechId.value = speechId
        val params = Bundle()
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, params, speechId)
    }

    fun stop() {
        tts?.stop()
        _activeSpeechId.value = null
    }

    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
        tts = null
        _activeSpeechId.value = null
    }
}
