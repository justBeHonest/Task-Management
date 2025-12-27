package com.ahmetaliasik.taskmanagement.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ahmetaliasik.taskmanagement.R
import com.ahmetaliasik.taskmanagement.presentation.components.AppBottomNavigationBar
import com.ahmetaliasik.taskmanagement.presentation.dashboard.DashboardView
import com.ahmetaliasik.taskmanagement.presentation.document.DocumentView
import com.ahmetaliasik.taskmanagement.presentation.profile.ProfileView
import com.ahmetaliasik.taskmanagement.presentation.todays_tasks.TodaysTaskView
import com.ahmetaliasik.taskmanagement.ui.theme.custom_shape.BottomNavbarCutOutShape


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(navigateToAddProjectInTaskView : () -> Unit) {
    val fabSize = 56.dp
    val fabOverlap = (fabSize / 2) + 17.dp

    val bottomNavController = rememberNavController()
    Scaffold(
        bottomBar = {
            AppBottomNavigationBar(
                navController = bottomNavController,
                modifier = Modifier
                    .windowInsetsPadding(NavigationBarDefaults.windowInsets)
                    .height(56.dp)
                    .clip(BottomNavbarCutOutShape(fabRadius = (fabSize - 4.dp).value))
            )
        }, floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                onClick = navigateToAddProjectInTaskView,
                modifier = Modifier
                    .offset(y = fabOverlap),
                /*.shadow(
                    elevation = 14.dp,
                    shape = CircleShape,
                    spotColor = MaterialTheme.colorScheme.primary,
                    ambientColor = MaterialTheme.colorScheme.primary
                ),*/
                containerColor = MaterialTheme.colorScheme.primary,
            ) {
                Icon(
                    painter = painterResource(R.drawable.add),
                    "Add Task",
                    modifier = Modifier.size(24.dp),
                )
            }
        }, floatingActionButtonPosition = FabPosition.Center
    ) {
        BottomNavGraph(navController = bottomNavController)
    }
}

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "dashboard") {
        composable("dashboard") { DashboardView() }
        composable("todays_tasks") { TodaysTaskView() }
        composable("document") { DocumentView() }
        composable("profile") { ProfileView() }
    }
}

@Preview
@Composable
fun HomeViewPreview() {
    HomeView(
        navigateToAddProjectInTaskView = {}
    )
}