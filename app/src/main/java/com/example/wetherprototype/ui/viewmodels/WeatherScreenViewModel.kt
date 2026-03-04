package com.example.wetherprototype.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wetherprototype.domain.model.units.PrecipitationUnit
import com.example.wetherprototype.domain.model.units.TemperatureUnit
import com.example.wetherprototype.domain.model.units.WindUnit
import com.example.wetherprototype.domain.model.weather.Location
import com.example.wetherprototype.domain.model.weather.WeatherData
import com.example.wetherprototype.domain.repository.LocationRepository
import com.example.wetherprototype.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.DayOfWeek
import java.util.Locale.getDefault
import javax.inject.Inject

data class WeatherSearchUiState(
    val query: String = "",
    val suggestions: List<Location> = emptyList(),
    val error: String? = null,
    val isLoading: Boolean = false
)

data class UnitsUiState(
    val temperatureUnit: TemperatureUnit = TemperatureUnit.CELSIUS,
    val windUnit: WindUnit = WindUnit.KMH,
    val precipitationUnit: PrecipitationUnit = PrecipitationUnit.MM
)

data class WeatherUiState(
    val isLoading: Boolean = false,
    val data: WeatherData? = null,
    val error: String? = null
)

@HiltViewModel
class WeatherScreenViewModel @Inject constructor(
    private val locationRepository: LocationRepository,
    private val weatherRepository: WeatherRepository
) : ViewModel() {
    private val _weather = MutableStateFlow(WeatherUiState())
    val weather = _weather.asStateFlow()

    private val _unitState = MutableStateFlow(UnitsUiState())
    val unitState = _unitState.asStateFlow()

    private val _searchState = MutableStateFlow(WeatherSearchUiState())
    val searchState = _searchState.asStateFlow()

    init {
        observeQueryChanges()
    }

    fun onTemperatureSelected(unit: TemperatureUnit) {
        _unitState.update {
            it.copy(temperatureUnit = unit)
        }
        fetchWeather(_weather.value.data?.location ?: return)
    }

    fun onWindSelected(unit: WindUnit) {
        _unitState.update {
            it.copy(windUnit = unit)
        }
        fetchWeather(_weather.value.data?.location ?: return)
    }

    fun onPrecipitationSelected(unit: PrecipitationUnit) {
        _unitState.update {
            it.copy(precipitationUnit = unit)
        }
        fetchWeather(_weather.value.data?.location ?: return)
    }

    fun onQueryChange(newQuery: String) {
        _searchState.update {
            it.copy(query = newQuery)
        }
        if (newQuery.isBlank()) {
            _searchState.update { it.copy(suggestions = emptyList()) }
        }
    }

    fun onDaySelected(day: String) {
        _weather.update { currentState ->
            val currentData = currentState.data ?: return@update currentState

            val selectedDayEnum = try {
                DayOfWeek.valueOf(day.uppercase())
            } catch (e: Exception) {
                currentData.hourlySection.selectedDay
            }

            currentState.copy(
                data = currentData.copy(
                    hourlySection = currentData.hourlySection.copy(
                        selectedDay = selectedDayEnum
                    )
                )
            )
        }
    }

    private fun observeQueryChanges() {
        viewModelScope.launch {
            searchState
                .map { it.query }
                .debounce(500)
                .filter { it.isNotBlank() }
                .distinctUntilChanged()
                .collectLatest { query ->
                    _searchState.update { it.copy(isLoading = true) }
                    try {
                        val results = locationRepository.searchLocation(query)
                        Log.d("WeatherScreenViewModel", "results: ${results.size}")
                        _searchState.update {
                            it.copy(
                                suggestions = results,
                                isLoading = false
                            )
                        }
                    } catch (e: Exception) {
                        _searchState.update {
                            it.copy(
                                error = e.message,
                                isLoading = false
                            )
                        }
                    }
                }
        }
    }

    fun deleteSuggestion(){
        _searchState.update {
            it.copy(suggestions = emptyList())
        }
    }

    fun fetchWeather(location: Location) {
        viewModelScope.launch {
            _weather.update { it.copy(isLoading = true, error = null) }
            try {
                val data = weatherRepository.getWeather(
                    location,
                    _unitState.value.temperatureUnit.name.lowercase(getDefault()),
                    _unitState.value.windUnit.name.lowercase(getDefault()),
                    _unitState.value.precipitationUnit.name.lowercase(getDefault())
                )
                _weather.update {
                    it.copy(
                        data = data,
                        isLoading = false
                    )
                }
                _searchState.update {
                    it.copy(
                        query = location.city,
                        suggestions = emptyList()
                    )
                }
            } catch (e: Exception) {
                _weather.update {
                    it.copy(
                        error = e.message,
                        isLoading = false
                    )
                }
            }
        }
    }
}