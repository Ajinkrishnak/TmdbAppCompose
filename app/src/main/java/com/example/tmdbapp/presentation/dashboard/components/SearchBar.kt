package com.example.tmdbapp.presentation.dashboard.components
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tmdbapp.presentation.Screen
import com.example.tmdbapp.ui.theme.WhiteTransparent

@Composable
fun SearchBar(navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(shape = RoundedCornerShape(30.dp))
            .background(WhiteTransparent)
            .clickable {
                navController.navigate(Screen.SearchPageScreen.route)
            },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Search for a movie...",
                style = MaterialTheme.typography.body1,
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 15.dp)
            )
            Icon(
                painter = painterResource(id = android.R.drawable.ic_menu_search),
                contentDescription = "search_icon",
                Modifier.padding(end = 20.dp),
                tint = Color.Black
            )

        }
    }
}