package com.example.tmdbapp.presentation

sealed class Screen(val route:String){
    object Dashboard: Screen("dashboard_screen")
    object ViewAll: Screen("view_all_screen")
    object MovieDetailsScreen: Screen("movie_details_screen")
    object YoutubePlayerScreen: Screen("youtube_player_screen")
    object SearchPageScreen: Screen("search_page_screen")
 }
