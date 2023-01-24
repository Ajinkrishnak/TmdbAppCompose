package com.example.tmdbapp.presentation.search_movie

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.tmdbapp.data.model.movies.MovieItem
import com.example.tmdbapp.presentation.dashboard.components.ErrorView
import com.example.tmdbapp.presentation.dashboard.components.IsLoading
import com.example.tmdbapp.presentation.dashboard.components.MovieItemCard
import com.example.tmdbapp.presentation.movie_details.components.SearchBar
import com.example.tmdbapp.presentation.search_movie.components.SearchEmpty
import com.example.tmdbapp.presentation.search_movie.components.SearchMovieItemCard
import com.example.tmdbapp.presentation.view_all.components.handlePagingResult

@Composable
fun SearchPageScreen(
    navController: NavController,
    viewModel: SearchPageViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.padding(20.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(30.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                SearchBar(
                    onSearch = { state ->
                        state.value.text.let { query ->
                            if (query.isNotBlank()) {
                                viewModel.searchMovie(query)
                            }
                        }
                        viewModel.searchMovie(state.value.text)
                    },
                    onCancel = { viewModel.clearSearch() })
            }
        }

        Box(modifier = Modifier.padding(top = 10.dp)) {
            SearchItemList(viewModel, navController)
            IsLoading(isLoading = viewModel.isLoading.value)
            ErrorView(viewModel.apiError.value)
            SearchEmpty(viewModel.listEmpty.value)
        }
    }
}

@Composable
fun SearchItemList(viewModel: SearchPageViewModel, navController: NavController) {
    LazyColumn() {
        items(
            items = viewModel.searchMoviePagingItems,
            key = { item ->
                item.movieId.toString()
            }
        ) { item ->
            SearchMovieItemCard(item, navController)
        }
    }
}


