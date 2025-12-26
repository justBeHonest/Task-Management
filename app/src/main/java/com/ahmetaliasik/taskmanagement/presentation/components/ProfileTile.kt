package com.ahmetaliasik.taskmanagement.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ahmetaliasik.taskmanagement.R

@Composable
fun ProfileTile(modifier: Modifier = Modifier) {
    val height = 46.dp
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()

    )
    {
        Image(
            painter = painterResource(R.drawable.avatar_image),
            contentDescription = "Avatar Image",
            modifier = Modifier.size(height)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .height(height),
            verticalArrangement = Arrangement.SpaceBetween,

            ) {
            Text("Hello!", style = MaterialTheme.typography.bodyLarge)
            Text("Livia Vaccaro", style = MaterialTheme.typography.titleLarge)
        }
        val badge = remember { true }
        NotificationIconWithBadge(badge = badge)

    }
}