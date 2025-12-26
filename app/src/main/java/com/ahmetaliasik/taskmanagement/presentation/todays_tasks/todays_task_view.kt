package com.ahmetaliasik.taskmanagement.presentation.todays_tasks

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ahmetaliasik.taskmanagement.presentation.components.AppBar
import com.ahmetaliasik.taskmanagement.ui.theme.TaskManagementTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodaysTaskView() {
    Scaffold(
        topBar = { AppBar(title = "Today's Tasks") }
    ) {

    }
}

@Preview
@Composable
private fun TodaysTasksPreview() {
    TaskManagementTheme {
        TodaysTaskView()
    }
}