package com.ahmetaliasik.taskmanagement.presentation.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmetaliasik.taskmanagement.R
import com.ahmetaliasik.taskmanagement.presentation.components.InProgressCard
import com.ahmetaliasik.taskmanagement.presentation.components.ProfileTile
import com.ahmetaliasik.taskmanagement.presentation.components.TaskGroupTile
import com.ahmetaliasik.taskmanagement.presentation.components.TitleWithNumber
import com.ahmetaliasik.taskmanagement.presentation.components.TodaysTaskCard
import com.ahmetaliasik.taskmanagement.presentation.home.HomeView
import com.ahmetaliasik.taskmanagement.ui.theme.TaskManagementTheme

@Composable
fun DashboardView() {
    LazyColumn(
        modifier = Modifier.padding(start = 22.dp, top = 28.dp, bottom = 24.dp, end = 22.dp)
    ) {
        item { ProfileTile() }
        item { Spacer(modifier = Modifier.height(24.dp)) }
        item { TodaysTaskCard() }
        item { Spacer(modifier = Modifier.height(24.dp)) }
        item {
            TitleWithNumber(
                number = 6, title = "In Progress"
            )
        }
        item { Spacer(modifier = Modifier.height(16.dp)) }
        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(5) {
                    InProgressCard(
                        indicatorColor = Color.Blue,
                        iconColor = Color(0xFFFF67BC),
                        projectType = "Office Project",
                        content = "Grocery shopping app",
                        percent = 0.6f
                    )
                }
            }
        }
        item { Spacer(modifier = Modifier.height(16.dp)) }
        item { TitleWithNumber(number = 4, title = "Task Groups") }
        item { Spacer(modifier = Modifier.height(16.dp)) }

        items(dummyList.size) {
            val taskGroup = dummyList[it]
            TaskGroupTile(
                title = taskGroup.title,
                taskCount = taskGroup.taskCount,
                progress = taskGroup.progress,
                color = taskGroup.color,
                painterId = taskGroup.painterId,
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        item { Spacer(modifier = Modifier.height(50.dp)) }
    }
}

data class TaskGroupData(
    val title: String, val taskCount: Int, val progress: Float, val color: Color, val painterId: Int
)

val dummyList = listOf<TaskGroupData>(
    TaskGroupData(
        title = "Office Project",
        taskCount = 23,
        progress = 0.7f,
        color = Color.Magenta,
        painterId = R.drawable.briefcase
    ), TaskGroupData(
        title = "Personal Project",
        taskCount = 30,
        progress = 0.52f,
        color = Color.Blue,
        painterId = R.drawable.user_octagon,
    ), TaskGroupData(
        title = "Daily Study",
        taskCount = 30,
        progress = 0.87f,
        color = Color.Red,
        painterId = R.drawable.book,
    ), TaskGroupData(
        title = "Daily Study",
        taskCount = 3,
        progress = 0.87f,
        color = Color.Yellow,
        painterId = R.drawable.book,
    )
)

@Preview
@Composable
fun HomeViewPreview() {
    TaskManagementTheme {
        HomeView(
            navigateToAddProjectInTaskView = {}
        )
    }
}