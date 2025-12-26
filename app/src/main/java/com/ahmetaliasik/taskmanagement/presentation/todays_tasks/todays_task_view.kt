package com.ahmetaliasik.taskmanagement.presentation.todays_tasks

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmetaliasik.taskmanagement.R
import com.ahmetaliasik.taskmanagement.ui.theme.TaskManagementTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodaysTaskView() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Today's Tasks", style = MaterialTheme.typography.titleLarge)
                },
                navigationIcon = {
                    Image(
                        painter = painterResource(R.drawable.arrow_left),
                        contentDescription = "Back",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                            }
                    )
                },
                actions = {
                    Image(
                        painter = painterResource(R.drawable.arrow_left),

                        contentDescription = "Back",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                            }
                    )
                }

            )
        }
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