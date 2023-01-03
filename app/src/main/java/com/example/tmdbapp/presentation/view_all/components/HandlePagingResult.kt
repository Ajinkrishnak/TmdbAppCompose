package com.example.tmdbapp.presentation.view_all.components

import androidx.compose.runtime.Composable
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.tmdbapp.data.model.movies.MovieItem
import com.example.tmdbapp.presentation.dashboard.components.ErrorView
import com.example.tmdbapp.presentation.dashboard.components.IsLoading

@Composable
fun handlePagingResult(
    movieItems: LazyPagingItems<MovieItem>,
) {
    movieItems.apply {
        val error = when {
            loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
            loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
            loadState.append is LoadState.Error -> loadState.append as LoadState.Error
            else -> null
        }

        return when {
            loadState.refresh is LoadState.Loading -> {
                IsLoading(isLoading = true)
            }
            error != null -> {
                ErrorView(true)
            }
            movieItems.itemCount < 1 -> {

            }
            else -> {

            }

        }
    }
}