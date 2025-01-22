package com.example.testwork.ui.dashboard

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testwork.data.Bin
import com.example.testwork.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class HistoryViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    private var _data = MutableStateFlow<List<Bin>>(emptyList())
    val data = _data.asStateFlow()


    fun getBin() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAlLBin().collect { bins ->
                if (bins.isNotEmpty()) {
                    // Обновление UI или дальнейшая обработка данных
                    Log.d("AllBins", "Получили данные: $bins")
                    _data.value = bins
                } else {
                    Log.d("AllBins", "Список пуст")
                }
            }
        }
    }
}