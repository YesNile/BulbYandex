package com.example.bulbyandex.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bulbyandex.UiState
import com.example.bulbyandex.data.DataColor
import com.example.bulbyandex.domain.GetColorsUseCase
import com.example.bulbyandex.domain.GetCurrentBrightnessUseCase
import com.example.bulbyandex.domain.GetCurrentColorUseCase
import com.example.bulbyandex.domain.GetStateUseCase
import com.example.bulbyandex.domain.SetBrightnessUseCase
import com.example.bulbyandex.domain.SetColorUseCase
import com.example.bulbyandex.domain.TurnOffUseCase
import com.example.bulbyandex.domain.TurnOnUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.bulbyandex.toUiState


class StatusViewModel @Inject constructor(
    private val getColorsUseCase: GetColorsUseCase,
    private val turnOnUseCase: TurnOnUseCase,
    private val turnOffUseCase: TurnOffUseCase,
    private val getStateUseCase: GetStateUseCase,
    private val getCurrentColorUseCase: GetCurrentColorUseCase,
    private val setColorUseCase: SetColorUseCase,
    private val setBrightnessUseCase: SetBrightnessUseCase,
    private val getBrightnessUseCase: GetCurrentBrightnessUseCase
): ViewModel() {


    private val _colors = MutableLiveData<UiState<List<String>?>>(UiState.Loading)
    private val _state = MutableLiveData<UiState<Boolean?>>(UiState.Loading)
    private val _currentColor = MutableLiveData<UiState<DataColor?>?>(UiState.Loading)
    private val _currentBrightness = MutableLiveData<UiState<Int?>?>(UiState.Loading)

    val colors: LiveData<UiState<List<String>?>>
        get() = _colors
    val state: LiveData<UiState<Boolean?>>
        get() = _state
    val currentColor: LiveData<UiState<DataColor?>?>
        get() = _currentColor
    val currentBrightness: LiveData<UiState<Int?>?>
        get() = _currentBrightness


    fun getState(){
        viewModelScope.launch {
            _state.postValue(getStateUseCase().toUiState())
        }
    }

    fun getCurrentColor() {
        viewModelScope.launch {
            _currentColor.postValue(getCurrentColorUseCase().toUiState())
        }
    }

    fun loadColors() {
        viewModelScope.launch {
            _colors.postValue(getColorsUseCase().toUiState())
        }
    }

    fun setColor(color: String) {
        viewModelScope.launch {
            setColorUseCase(color)
        }
    }

    fun setBrightness(level: Int) {
        viewModelScope.launch {
            setBrightnessUseCase(level)
        }
    }

    fun getBrightness(){
        viewModelScope.launch {
            _currentBrightness.postValue(getBrightnessUseCase().toUiState())
        }
    }

    fun turnOn(){
        viewModelScope.launch {
            turnOnUseCase()
        }
    }
    fun turnOff(){
        viewModelScope.launch {
            turnOffUseCase()
        }
    }
}


