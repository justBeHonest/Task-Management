package com.ahmetaliasik.taskmanagement.presentation.add_project_in_task_list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ahmetaliasik.taskmanagement.presentation.components.AppBar
import com.ahmetaliasik.taskmanagement.ui.theme.TaskManagementTheme

@Composable
fun AddProjectInTaskList() {
    Scaffold(
        topBar = { AppBar(title = "Add Project") }
    ) { }
}

@Preview
@Composable
private fun AddProfectInTaskListPreview() {
    TaskManagementTheme {
        AddProjectInTaskList()
    }
}