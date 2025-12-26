package com.ahmetaliasik.taskmanagement.presentation.todays_tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmetaliasik.taskmanagement.presentation.components.AppBar
import com.ahmetaliasik.taskmanagement.ui.theme.TaskManagementTheme
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodaysTaskView() {
    Scaffold(
        topBar = { AppBar(title = "Today's Tasks") }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(start = 22.dp, end = 22.dp)
        ) {
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                CalendarView(modifier = Modifier.fillMaxWidth())
            }
        }
    }
}

@Composable
fun CalendarView(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        val today = LocalDate.now()
        val fiveDays = arrayOf(
            today.minusDays(2),
            today.minusDays(1),
            today,
            today.plusDays(1),
            today.plusDays(2),
        )
        repeat(5) {
            val paddingVertical = 8.dp
            val paddingHorizontal = 20.dp
            DayComponent(
                date = fiveDays[it],
                modifier = if (fiveDays[it].equals(today)) Modifier
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .padding(vertical = paddingVertical, horizontal = paddingHorizontal)
                else Modifier
                    .padding(vertical = paddingVertical, horizontal = paddingHorizontal)

            )
        }
    }
}

@Composable
fun DayComponent(modifier: Modifier = Modifier, date: LocalDate) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val textColor =
            if (date == LocalDate.now()) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onBackground
        Text(
            text = date.month.getDisplayName(TextStyle.SHORT, Locale.getDefault()),
            style = MaterialTheme.typography.bodyMedium,
            color = textColor
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = date.dayOfMonth.toString(),
            style = MaterialTheme.typography.titleLarge,
            color = textColor
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = date.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault()),
            style = MaterialTheme.typography.bodyMedium,
            color = textColor
        )
    }
}

@Preview
@Composable
private fun TodaysTasksPreview() {
    TaskManagementTheme {
        TodaysTaskView()
    }
}