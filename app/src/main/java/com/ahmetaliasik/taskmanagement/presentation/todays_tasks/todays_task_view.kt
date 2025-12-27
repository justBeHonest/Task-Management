package com.ahmetaliasik.taskmanagement.presentation.todays_tasks

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmetaliasik.taskmanagement.R
import com.ahmetaliasik.taskmanagement.core.enum.PrimaryButtonType
import com.ahmetaliasik.taskmanagement.core.enum.TaskGroup
import com.ahmetaliasik.taskmanagement.core.enum.TaskType
import com.ahmetaliasik.taskmanagement.core.model.Task
import com.ahmetaliasik.taskmanagement.presentation.components.AppBar
import com.ahmetaliasik.taskmanagement.presentation.components.IconContainer
import com.ahmetaliasik.taskmanagement.presentation.components.PrimaryButton
import com.ahmetaliasik.taskmanagement.ui.theme.TaskManagementTheme
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodaysTaskView() {
    Scaffold(
        topBar = {
            AppBar(title = "Today's Tasks")
        }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(start = 22.dp, end = 22.dp),

            ) {
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item { CalendarView(modifier = Modifier.fillMaxWidth()) }
            item { Spacer(modifier = Modifier.height(32.dp)) }
            item {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(34.dp),
                ) {
                    item {
                        PrimaryButton(
                            text = "All", onClick = {}, buttonType = PrimaryButtonType.Primary
                        )
                    }
                    item { PaddingHorizontal() }
                    item {
                        PrimaryButton(
                            text = "Todo", onClick = {}, buttonType = PrimaryButtonType.Disabled
                        )
                    }
                    item { PaddingHorizontal() }
                    item {
                        PrimaryButton(
                            text = "In Progress",
                            onClick = {},
                            buttonType = PrimaryButtonType.Disabled
                        )
                    }
                    item { PaddingHorizontal() }
                    item {
                        PrimaryButton(
                            text = "Completed",
                            onClick = {},
                            buttonType = PrimaryButtonType.Disabled
                        )
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(44.dp)) }

            items(dummyTasks.size) { index ->
                val task = dummyTasks[index]
                TaskCard(
                    title = task.title,
                    subTitle = task.description,
                    taskType = task.taskType,
                    taskGroup = task.taskGroup,
                    painterId = task.taskGroup.painterId,
                    taskCound = 0,
                    date = task.date,
                )
                Spacer(modifier = Modifier.height(48.dp))
            }

        }
    }
}

val dummyTasks = listOf<Task>(
    Task(
        taskType = TaskType.Completed,
        taskGroup = TaskGroup.OfficeProject,
        title = "Market Research",
        description = "Grocery shopping app design",
        date = LocalDateTime.now()
    ), Task(
        taskType = TaskType.InProgress,
        taskGroup = TaskGroup.OfficeProject,
        title = "Competitive Analysis",
        description = "Grocery shopping app design",
        date = LocalDateTime.now()
    ), Task(
        taskType = TaskType.Todo,
        taskGroup = TaskGroup.PersonalProject,
        title = "Create Low-fidelity Wireframe",
        description = "Uber Eats redesign challange",
        date = LocalDateTime.now()
    ), Task(
        taskType = TaskType.Todo,
        taskGroup = TaskGroup.DailyStudy,
        title = "How to pitch a Design Sprint",
        description = "About design sprint",
        date = LocalDateTime.now()
    )
)

@Composable
fun TaskCard(
    modifier: Modifier = Modifier,
    taskType: TaskType,
    taskGroup: TaskGroup,
    title: String,
    subTitle: String,
    painterId: Int,
    taskCound: Int,
    date: LocalDateTime
) {
    Box(modifier = modifier) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start,
        ) {
            val rowArrangement = Arrangement.SpaceBetween
            Row(horizontalArrangement = rowArrangement, modifier = modifier.fillMaxWidth()) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
                IconContainer(
                    iconColor = taskGroup.color,
                    painterId = taskGroup.painterId,
                    size = 14.dp,
                )
            }
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = title, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Row(horizontalArrangement = rowArrangement, modifier = modifier.fillMaxWidth()) {
                Row {
                    val formattedDate = date.format(DateTimeFormatter.ofPattern("HH:MM"))
                    val timeColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.65f);
                    Image(
                        painter = painterResource(R.drawable.time_circle),
                        contentDescription = "Time circle Icon",
                        modifier = Modifier.size(14.dp),
                        colorFilter = ColorFilter.tint(color = timeColor)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = formattedDate,
                        style = MaterialTheme.typography.bodyMedium,
                        color = timeColor
                    )
                }
                TextWithColorfulBackground(text = taskType.text, color = taskType.color)
            }
        }
    }
}

@Composable
fun TextWithColorfulBackground(modifier: Modifier = Modifier, text: String, color: Color) {
    Text(
        text = text,
        color = color,
        style = MaterialTheme.typography.bodySmall,
        modifier = Modifier
            .background(
                color = color.copy(alpha = 0.1f), shape = RoundedCornerShape(7.dp)
            )
            .padding(vertical = 1.dp, horizontal = 5.dp)
    )
}

@Composable
private fun PaddingHorizontal() {
    Spacer(modifier = Modifier.width(16.dp))
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
                date = fiveDays[it], modifier = if (fiveDays[it].equals(today)) Modifier
                    .background(
                        color = MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(15.dp)
                    )
                    .padding(vertical = paddingVertical, horizontal = paddingHorizontal)
                else Modifier.padding(vertical = paddingVertical, horizontal = paddingHorizontal)

            )
        }
    }
}

@Composable
fun DayComponent(modifier: Modifier = Modifier, date: LocalDate) {
    Column(
        modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally
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