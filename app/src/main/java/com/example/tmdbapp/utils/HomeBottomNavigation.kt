package com.example.tmdbapp.utils

import com.example.tmdbapp.R

sealed class HomeBottomNavigation(val title: String, val icon: Int, val route: String) {

    object Home : HomeBottomNavigation("Home", R.drawable.ic_home, "home")
    object Favorite : HomeBottomNavigation("Favorite", R.drawable.ic_favorite, "favorite")
    object Profile : HomeBottomNavigation("Profile", R.drawable.ic_profile, "profile")


}