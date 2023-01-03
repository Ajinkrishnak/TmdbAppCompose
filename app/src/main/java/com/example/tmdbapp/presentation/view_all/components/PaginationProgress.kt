package com.example.tmdbapp.presentation.view_all.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun PaginationProgress() {
   Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
       CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
   }
}