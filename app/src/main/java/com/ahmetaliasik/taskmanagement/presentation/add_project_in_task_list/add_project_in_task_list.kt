package com.ahmetaliasik.taskmanagement.presentation.add_project_in_task_list

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmetaliasik.taskmanagement.R
import com.ahmetaliasik.taskmanagement.core.enum.PrimaryButtonType
import com.ahmetaliasik.taskmanagement.core.enum.TaskGroup
import com.ahmetaliasik.taskmanagement.presentation.components.AppBar
import com.ahmetaliasik.taskmanagement.presentation.components.DateSelectorCard
import com.ahmetaliasik.taskmanagement.presentation.components.IconContainer
import com.ahmetaliasik.taskmanagement.presentation.components.ImagePickerCard
import com.ahmetaliasik.taskmanagement.presentation.components.PrimaryButton
import com.ahmetaliasik.taskmanagement.presentation.viewmodel.TaskViewModel
import com.ahmetaliasik.taskmanagement.ui.theme.TaskManagementTheme
import java.time.LocalDateTime
import java.time.ZoneId

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProjectInTaskList(
    viewModel: TaskViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    var selectedGroup by remember { mutableStateOf(TaskGroup.OfficeProject) }
    var projectName by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    var startDate by remember { mutableStateOf<Long?>(null) }
    var endDate by remember { mutableStateOf<Long?>(null) }

    var activeDateSelection by remember { mutableStateOf<String?>(null) }
    val datePickerState = rememberDatePickerState()

    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
    ) { uri: Uri? -> selectedImageUri = uri }

    if (activeDateSelection != null) {
        DatePickerDialog(
            onDismissRequest = { activeDateSelection = null },
            confirmButton = {
                TextButton(
                    onClick = {
                        datePickerState.selectedDateMillis?.let { millis ->
                            if (activeDateSelection == "start") {
                                startDate = millis
                            } else {
                                endDate = millis
                            }
                        }
                        activeDateSelection = null
                    }) {
                    Text(text = "Cancel")
                }
            },
            dismissButton = {
                TextButton(onClick = { activeDateSelection = null }) { Text(text = "Cancel") }
            },
        ) {
            DatePicker(state = datePickerState)
        }
    }

    Scaffold(
        topBar = { AppBar(title = "Add Project") },
        floatingActionButton = {
            PrimaryButton(
                onClick = {

                    if (projectName.isNotEmpty() && startDate != null && endDate != null) {
                        val nowSinceEproach = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                        viewModel.saveTask(
                            title = projectName,
                            description = description,
                            group = selectedGroup,
                            startDate = startDate ?: nowSinceEproach,
                            endDate = endDate ?: nowSinceEproach,
                            imageUri = selectedImageUri?.toString()
                        )
                    }
                },
                buttonType = PrimaryButtonType.Primary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 22.dp)
                    .height(52.dp)

            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "Add Project", style = MaterialTheme.typography.titleLarge)
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(22.dp)
        ) {
            item {
                TaskGroupSelector(
                    selectedGroup = selectedGroup, onGroupSelected = { newGroup ->
                        selectedGroup = newGroup
                    })
            }
            item { Spacer(modifier = Modifier.height(24.dp)) }
            item {
                AppTextField(
                    label = "Project Name",
                    value = projectName,
                    onValueChange = { projectName = it })
            }
            item { Spacer(modifier = Modifier.height(24.dp)) }
            item {
                AppTextField(
                    label = "Description",
                    value = description,
                    onValueChange = { description = it },
                    minLines = 3,
                    maxLines = 10,
                    singleLine = false,
                )
            }
            item { Spacer(modifier = Modifier.height(24.dp)) }

            item {
                DateSelectorCard(
                    title = "Start Date", dateMillis = startDate, onClick = {
                        activeDateSelection = "start"
                    })
            }

            item {
                Spacer(modifier = Modifier.height(24.dp))
            }

            item {
                DateSelectorCard(
                    title = "End Date",
                    dateMillis = endDate,
                    onClick = {
                        activeDateSelection = "end"
                    },
                )
            }

            item { Spacer(modifier = Modifier.height(24.dp)) }

            item {
                ImagePickerCard(
                    selectedImageUri = selectedImageUri,
                    onChangeLogoClicked = {
                        imagePickerLauncher.launch("image/*")
                    }
                )
            }
        }
    }
}

@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    minLines: Int = 1,
    maxLines: Int? = null,
    singleLine: Boolean = true,
) {
    Box(modifier = modifier) {
        Surface(
            shape = RoundedCornerShape(15.dp),
            color = MaterialTheme.colorScheme.surface,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 63.dp),
                label = {
                    Text(
                        text = label
                    )
                },
                minLines = minLines,
                maxLines = if (singleLine) 1 else maxLines ?: Int.MAX_VALUE,
                singleLine = singleLine,
                textStyle = MaterialTheme.typography.bodyLarge,
                placeholder = { Text(text = label) },
                value = value,
                onValueChange = onValueChange,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    cursorColor = MaterialTheme.colorScheme.primary,
                ),
                shape = RoundedCornerShape(15.dp)
            )
        }
    }
}

@Composable
fun TaskGroupSelector(selectedGroup: TaskGroup, onGroupSelected: (TaskGroup) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Surface(
            onClick = { expanded = true },
            shape = RoundedCornerShape(15.dp),
            color = MaterialTheme.colorScheme.surface,
            modifier = Modifier
                .fillMaxWidth()
                .height(63.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconContainer(
                        iconColor = selectedGroup.color,
                        painterId = selectedGroup.painterId,
                        size = 14.dp
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = "Task Group",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray,
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = selectedGroup.name,
                            style = MaterialTheme.typography.titleSmall,
                        )
                    }
                }
                Icon(
                    painter = painterResource(id = R.drawable.arrow_down),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }

        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth(0.9f)
        ) {
            TaskGroup.entries.forEach { group ->
                DropdownMenuItem(text = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = group.painterId),
                            contentDescription = null,
                            tint = group.color,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(text = group.name)
                    }
                }, onClick = {
                    onGroupSelected(group)
                    expanded = false
                })
            }
        }
    }
}

@Preview
@Composable
private fun AddProfectInTaskListPreview() {
    TaskManagementTheme {
        AddProjectInTaskList()
    }
}