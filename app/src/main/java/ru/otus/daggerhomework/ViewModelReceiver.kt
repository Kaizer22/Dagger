package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    private val uiState: MutableStateFlow<AppUiState>,
    @ApplicationContext private val context: Context
) {
    suspend fun observeColors(collector: FlowCollector<AppUiState>) {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        uiState.collect(collector)
    }
}