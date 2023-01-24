package com.example.tmdbapp.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tmdbapp.presentation.dashboard.DashboardScreen
import com.example.tmdbapp.presentation.movie_details.MovieDetailsScreen
import com.example.tmdbapp.presentation.movie_details.YoutubePlayerScreen
import com.example.tmdbapp.presentation.search_movie.SearchPageScreen
import com.example.tmdbapp.presentation.view_all.ViewAllScreen

@ExperimentalAnimationApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Dashboard.route) {

        // Dashboard Screen
        composable(route = Screen.Dashboard.route) {
            DashboardScreen(navController = navController)
        }

        //View All movies screen
        composable(
            route = Screen.ViewAll.route + "?moviesType={moviesType}", arguments = listOf(
                navArgument(name = "moviesType") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            val moviesType = it.arguments?.getString("moviesType") ?: ""
            ViewAllScreen(navController = navController, moviesType)
        }

        // Movie Details Screen
        composable(
            route = Screen.MovieDetailsScreen.route + "?movieId={movieId}&moviesTitle={moviesTitle}",
            arguments = listOf(
                navArgument(name = "movieId") {
                    type = NavType.StringType
                    defaultValue = ""
                },
                navArgument(name = "moviesTitle") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            val moviesTitle = it.arguments?.getString("moviesTitle") ?: ""
            val movieId = it.arguments?.getString("movieId") ?: ""
            MovieDetailsScreen(navController = navController, moviesTitle)
        }

        // Youtube Player Screen
        composable(
            route = Screen.YoutubePlayerScreen.route + "youtubeCode={youtubeCode}",
            arguments = listOf(
                navArgument(name = "youtubeCode") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            val youtubeCode = it.arguments?.getString("youtubeCode") ?: ""
            YoutubePlayerScreen(navController = navController, youtubeCode)
        }

        // Search Page Screen
        composable(
            route = Screen.SearchPageScreen.route
        ) {
            SearchPageScreen(navController = navController)
        }


    }
}