package com.example.tmdbapp.presentation.view_all

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.tmdbapp.data.model.movies.MovieItem
import com.example.tmdbapp.presentation.dashboard.MoviesType
import com.example.tmdbapp.presentation.dashboard.components.*
import com.example.tmdbapp.presentation.view_all.components.PaginationProgress
import com.example.tmdbapp.presentation.view_all.components.ToolBar
import com.example.tmdbapp.presentation.view_all.components.handlePagingResult

@Composable
fun ViewAllScreen(
    navController: NavController,
    moviesType: String,
    viewModel: ViewAllViewModel = hiltViewModel()
) {
    Scaffold(topBar = {
        ToolBar(title = moviesType, onBack = {
            navController.popBackStack()
        })
    }) { paddingValues ->
        Box(modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding())) {
            val movieItems = selectList(moviesType, viewModel)
            val modifier =
                if (movieItems.loadState.append == LoadState.Loading)
                    Modifier.padding(bottom = 80.dp)
                else Modifier.fillMaxSize()
            LazyVerticalGrid(modifier = modifier, columns = GridCells.Adaptive(128.dp), content = {
                items(movieItems.itemCount) { i ->
                    Row {
                        movieItems[i]?.let {
                            MovieItemCard(
                                item = it,
                                modifier = Modifier
                                    .fillMaxWidth(),
                                navController = navController
                            )
                        }
                    }
                }
            })
            if (movieItems.loadState.append == LoadState.Loading)
                PaginationProgress()
            else {
                handlePagingResult(movieItems)
            }
        }
    }
}

@Composable
fun selectList(moviesType: String, viewModel: ViewAllViewModel): LazyPagingItems<MovieItem> {
    return when (moviesType) {
        MoviesType.POPULAR.value -> viewModel.popularMoviesPagingItems.collectAsLazyPagingItems()
        MoviesType.NOW_PLAYING.value -> viewModel.nowPlayingMoviesPagingItems.collectAsLazyPagingItems()
        MoviesType.UPCOMING.value -> viewModel.upcomingMoviesPagingItems.collectAsLazyPagingItems()
        else -> {
            viewModel.topRatedMoviesPagingItems.collectAsLazyPagingItems()
        }
    }
}