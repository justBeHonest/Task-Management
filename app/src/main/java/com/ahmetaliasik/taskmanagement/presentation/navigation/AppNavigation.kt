package com.ahmetaliasik.taskmanagement.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ahmetaliasik.taskmanagement.presentation.add_project_in_task_list.AddProjectInTaskList
import com.ahmetaliasik.taskmanagement.presentation.home.HomeView
import com.ahmetaliasik.taskmanagement.presentation.letsstart.LetsStartView

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "lets_start"
    ) {
        composable("lets_start") {
            LetsStartView(
                onNavigateToHome = {
                    navController.navigate("home") {
                        popUpTo("lets_start") { inclusive = true }
                    }
                }
            )
        }

        composable("home") {
            HomeView(
                navigateToAddProjectInTaskView = {
                    navController.navigate("add_project")
                }
            )
        }

        composable("add_project") { AddProjectInTaskList() }
    }
}