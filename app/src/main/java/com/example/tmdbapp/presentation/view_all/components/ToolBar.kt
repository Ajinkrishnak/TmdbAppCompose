package com.example.tmdbapp.presentation.view_all.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ToolBar(title: String,onBack:() -> Unit) {
    TopAppBar(
        backgroundColor = Color.White,
        elevation = 0.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // size of an icon and placeholder box on the right side
            val iconSize = 28.dp

            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow Back",
                modifier = Modifier.padding(start = 15.dp)
                    .clickable {
                        onBack()
                    }
                    .size(iconSize)
            )
            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                fontSize = 20.sp,
                color = Color.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            // placeholder on the right side in order to have centered title - might be replaced with icon
            Box(
                modifier = Modifier
                    .padding(end = 15.dp)
                    .size(iconSize)
            ) { }
        }
    }
}