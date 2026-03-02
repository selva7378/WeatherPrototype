package com.example.wetherprototype.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wetherprototype.domain.model.Location
import com.example.wetherprototype.domain.model.WeatherUiModel
import com.example.wetherprototype.ui.preview.WeatherPreviewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import javax.inject.Inject

//data class WeatherUiState(
//    val query: String = "",
//    val suggestions: List<Location> = emptyList(),
//    val isSearching: Boolean = false,
//    val weather: WeatherData? = null,
//    val error: String? = null
//)
@HiltViewModel
class WeatherScreenViewModel @Inject constructor(
//    private val weatherRepository: WeatherRepository
): ViewModel() {
    private val _weather = MutableStateFlow<WeatherUiModel>(WeatherPreviewData.weather)
    val weather = _weather.asStateFlow()

    private val _query = MutableStateFlow("")
    val query = _query.asStateFlow()

    private val _searchResults = MutableStateFlow<List<Location>>(emptyList())
    val searchResults = _searchResults.asStateFlow()


    init {
        observeSearch()
    }

    fun updateQuery(newQuery: String) {
        _query.value = newQuery
    }

    private fun observeSearch() {
        viewModelScope.launch {
            _query
                .debounce(500)
                .filter { it.isNotBlank() }
                .distinctUntilChanged()
                .collectLatest { city ->
//                    val result = repository.searchLocation(city) // Geocoding API
//                    _suggestions.value = result
                }
        }
    }

    fun fetchWeather(lat: Double, lon: Double) {
        viewModelScope.launch {
//            repository.getWeather(lat, lon)
        }
    }
}