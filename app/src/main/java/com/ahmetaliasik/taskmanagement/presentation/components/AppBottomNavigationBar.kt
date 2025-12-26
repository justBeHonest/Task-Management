package com.ahmetaliasik.taskmanagement.presentation.components

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ahmetaliasik.taskmanagement.R
import com.ahmetaliasik.taskmanagement.presentation.home.HomeView


sealed class BottomNavItem(val route: String, val unselectedIcon: Int, val selectedIcon: Int) {
    object Home : BottomNavItem("dashboard", R.drawable.bulk_home, R.drawable.bold_home)
    object TodaysTasks :
        BottomNavItem("todays_tasks", R.drawable.calendar, R.drawable.bold_calendar)

    object Document : BottomNavItem("document", R.drawable.documen_text, R.drawable.documen_text)
    object Profile : BottomNavItem("profile", R.drawable.profile_user, R.drawable.profile_user)
}

@Composable
fun AppBottomNavigationBar(modifier: Modifier = Modifier, navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.TodaysTasks,
        null,
        BottomNavItem.Document,
        BottomNavItem.Profile
    )

    BottomAppBar(
        modifier = modifier, containerColor = MaterialTheme.colorScheme.surface,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            item?.let {
                NavigationBarItem(
                    icon = {
                        val isSelected = currentRoute == item.route
                        val iconRes = if (isSelected) item.selectedIcon else item.unselectedIcon
                        Icon(
                            painter = painterResource(id = iconRes),
                            contentDescription = item.route,
                            modifier = Modifier
                                .size(24.dp)
                                .shadow(
                                    elevation = if (isSelected) 14.dp else 0.dp,
                                    spotColor = MaterialTheme.colorScheme.primary,
                                    ambientColor = MaterialTheme.colorScheme.primary,
                                )
                        )
                    },

                    colors = NavigationBarItemDefaults.colors(
                        unselectedIconColor = MaterialTheme.colorScheme.primary,
                        indicatorColor = Color.Transparent,
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                    ),

                    // label = { Text(text = item.label) },
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            } ?: NavigationBarItem(
                selected = false,
                onClick = {},
                icon = {},
                enabled = false
            )
        }


    }
}

@Preview
@Composable
fun HomeViewPreview() {
    HomeView()
}