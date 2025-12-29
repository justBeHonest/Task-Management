package com.ahmetaliasik.taskmanagement.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ahmetaliasik.taskmanagement.R
import com.ahmetaliasik.taskmanagement.presentation.viewmodel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    title: String,
    viewModel: TaskViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
) {
    val taskCount by viewModel.todaysTaskCount.collectAsState()

    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(text = title, style = MaterialTheme.typography.titleLarge)
        },
        navigationIcon = {
            Image(
                painter = painterResource(R.drawable.arrow_left),
                contentDescription = "Back",
                modifier = Modifier
                    .padding(start = 22.dp)
                    .size(24.dp)
                    .clickable {
                    }
            )
        },
        actions = {
            NotificationIconWithBadge(
                modifier = Modifier.padding(end = 22.dp),
                badge = taskCount > 0
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background, // Arkaplan rengi
            titleContentColor = MaterialTheme.colorScheme.onBackground, // Başlık rengi
            navigationIconContentColor = MaterialTheme.colorScheme.onBackground, // Sol ikon rengi
            actionIconContentColor = MaterialTheme.colorScheme.onBackground // Sağ ikon rengi
        )

    )
}