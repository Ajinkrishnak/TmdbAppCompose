package com.example.tmdbapp.presentation.search_movie.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.tmdbapp.BuildConfig
import com.example.tmdbapp.R
import com.example.tmdbapp.data.model.movies.MovieItem
import com.example.tmdbapp.presentation.Screen

@Composable
fun SearchMovieItemCard(item: MovieItem?, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .background(color = Color.White)
            .clickable {
                navController.navigate(Screen.MovieDetailsScreen.route + "?movieId=${item?.movieId.toString()}&moviesTitle=${item?.title}")
            },
        shape = RoundedCornerShape(10.dp)
    ) {
        Row {
            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(BuildConfig.ORIGINAL_IMAGE_URL + item?.posterPath)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(R.string.description),
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(150.dp)
                    .height(160.dp),
                loading = {
                    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.anim_img_loading))
                    LottieAnimation(
                        composition = composition,
                        iterations = LottieConstants.IterateForever,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            )
            Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                Spacer(modifier = Modifier.height(10.dp))
                val lineHeight = MaterialTheme.typography.h6.fontSize * 4 / 3
                val lineHeight2 = MaterialTheme.typography.caption.fontSize * 4 / 3
                Text(
                    text = item?.title ?: "",
                    style = MaterialTheme.typography.body1,
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = lineHeight
                )
                Text(
                    text = item?.releaseDate ?: "",
                    style = MaterialTheme.typography.caption,
                )
                Spacer(modifier = Modifier.height(10.dp))
//                Text(
//                    text = "Overview",
//                    style = MaterialTheme.typography.h5,
//                    maxLines = 1,
//                    modifier = Modifier.padding(start = 15.dp)
//                )
//                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = item?.overview ?: "",
                    style = MaterialTheme.typography.caption,
                    lineHeight = lineHeight2,
                    maxLines = 5,
                )
                Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }
}