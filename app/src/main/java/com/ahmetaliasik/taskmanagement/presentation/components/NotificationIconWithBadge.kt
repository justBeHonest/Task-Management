package com.ahmetaliasik.taskmanagement.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ahmetaliasik.taskmanagement.R

@Composable
fun NotificationIconWithBadge(modifier: Modifier = Modifier, badge: Boolean) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.notification),
            contentDescription = "Notification",
            modifier = Modifier.size(24.dp)
        )
        if (badge) Badge(
            modifier = Modifier
                .offset(13.dp, (0).dp)
                .size(8.dp),
            containerColor = MaterialTheme.colorScheme.primary,
        )
    }
}