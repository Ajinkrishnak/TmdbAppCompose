package com.example.tmdbapp.presentation.movie_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CircularProgress(progressValue: Float) {
    Box(
        modifier = Modifier
            .width(50.dp)
            .height(50.dp)
            .clip(shape = CircleShape)
            .background(color = Color.Black)
    ) {
        CircularProgressIndicator(
            progress = progressValue,
            color = Color.Yellow,
            modifier = Modifier
                .align(Alignment.Center)
                .height(38.dp)
                .width(38.dp),

            )
        val percentage = (progressValue * 100).toInt()
        Text(
            text = buildAnnotatedString {
                append("$percentage");
                withStyle(style = SpanStyle(fontSize = 10.sp)) {
                    append(
                        "%"
                    )
                }
            },
            color = Color.White,
            style = MaterialTheme.typography.body2,
            fontSize = 12.sp,
            maxLines = 1,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}