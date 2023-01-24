package com.example.tmdbapp.presentation.dashboard.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.tmdbapp.R

@Composable
fun TopBar(navController: NavController, visibilty: Boolean?) {
    if (visibilty == true) {
        Box(contentAlignment = Alignment.CenterStart) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://image.tmdb.org/t/p/w1920_and_h600_multi_faces_filter%28duotone,032541,01b4e4%29/sfjqJDmNqMIImO5khiddb9TARvO.jpg")
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(R.string.description),
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
//                            .clip(shape = RoundedCornerShape(10.dp))
            )
            Column(modifier = Modifier.padding(horizontal = 15.dp)) {
                Text(
                    text = "Welcome",
                    style = MaterialTheme.typography.h4,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                Text(
                    text = "Millions of movies, TV shows and people to discover. Explore now.",
                    style = MaterialTheme.typography.body1,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                SearchBar(navController)
            }
        }

    }
}
