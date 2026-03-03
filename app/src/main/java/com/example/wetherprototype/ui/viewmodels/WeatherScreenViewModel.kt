package com.example.wetherprototype.ui.viewmodels

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
import javax.inject.Inject

data class WeatherSearchUiState(
    val query: String = "",
    val suggestions: List<Location> = emptyList(),
    val error: String? = null
)

data class UnitsUiState(
    val temperatureUnit: TemperatureUnit = TemperatureUnit.CELSIUS,
    val windUnit: WindUnit = WindUnit.KMH,
    val precipitationUnit: PrecipitationUnit = PrecipitationUnit.MM
)

data class WeatherUiState(
    val isLoading: Boolean = true,
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



    private val _searchState =
        MutableStateFlow(WeatherSearchUiState())
    val searchState = _searchState.asStateFlow()

    init {
        observeQueryChanges()
    }


    fun onTemperatureSelected(unit: TemperatureUnit) {
        _unitState.update {
            it.copy(temperatureUnit = unit)
        }
    }

    fun onWindSelected(unit: WindUnit) {
        _unitState.update {
            it.copy(windUnit = unit)
        }
    }

    fun onPrecipitationSelected(unit: PrecipitationUnit) {
        _unitState.update {
            it.copy(precipitationUnit = unit)
        }
    }

    fun onQueryChange(newQuery: String) {
        _searchState.update {
            it.copy(query = newQuery)
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
                .map { it.query }              // observe only query
                .debounce(500)                 // wait 500ms
                .filter { it.isNotBlank() }
                .distinctUntilChanged()
                .collectLatest { query ->



                    val results =
                        locationRepository.searchLocation(query)

                    _searchState.update {
                        it.copy(
                            suggestions = results
                        )
                    }
                }
        }
    }

    fun fetchWeather(location: Location) {
        viewModelScope.launch {
            weatherRepository.getWeather(location.latitude,location.longitude )

            _searchState.update {
                it.copy(
                    query = "",
                    suggestions = emptyList()
                )
            }
        }
    }
}


