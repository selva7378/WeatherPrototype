//package com.example.wetherprototype.ui.screens.weatherscreen
//
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Search
//import androidx.compose.material3.Button
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.ListItem
//import androidx.compose.material3.ListItemDefaults
//import androidx.compose.material3.SearchBar
//import androidx.compose.material3.SearchBarDefaults
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.State
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.semantics.isTraversalGroup
//import androidx.compose.ui.semantics.semantics
//import androidx.compose.ui.semantics.traversalIndex
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//
//@Composable
//fun SearchSection() {
//    Button(
//        onClick = { /*TODO*/ },
//        modifier = Modifier
//            .padding(12.dp)
//            .fillMaxWidth()
//    ) {
//                    CustomizableSearchBar(
//                        query = "",
//                        onQueryChange = TODO(),
//                        onSearch = TODO(),
//                        searchResults = TODO(),
//                        onResultClick = TODO(),
//                        modifier = TODO(),
//                        placeholder = TODO(),
//                        leadingIcon = TODO(),
//                        trailingIcon = TODO(),
//                        supportingContent = TODO(),
//                        leadingContent = TODO()
//                    )
//        Text(
//            text = "Search",
//            textAlign = TextAlign.Center
//        )
//    }
//}
//
//
//@Composable
//fun WeatherSearchScreen(
//    query: State
//) {
//
//    val query by viewModel.query.collectAsState()
//    val suggestions by viewModel.suggestions.collectAsState()
//
//    Column {
//
//        TextField(
//            value = query,
//            onValueChange = { viewModel.updateQuery(it) },
//            placeholder = { Text("Search city") },
//            leadingIcon = {
//                Icon(Icons.Default.Search, contentDescription = null)
//            },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        LazyColumn {
//            items(suggestions) { location ->
//
//                Text(
//                    text = "${location.name}, ${location.country}",
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .clickable {
//                            viewModel.fetchWeather(
//                                lat = location.lat,
//                                lon = location.lon
//                            )
//                        }
//                        .padding(16.dp)
//                )
//            }
//        }
//    }
//}
//
