package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val uiState: MutableStateFlow<AppUiState>,
    private val colorGenerator: ColorGenerator,
    @ActivityContext private val context: Context
) {
    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        uiState.value = AppUiState.ColorChangeEvent(colorGenerator.generateColor())
    }
}