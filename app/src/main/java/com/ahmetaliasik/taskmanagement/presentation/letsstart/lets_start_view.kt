package com.ahmetaliasik.taskmanagement.presentation.letsstart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmetaliasik.taskmanagement.R
import com.ahmetaliasik.taskmanagement.core.enum.PrimaryButtonType
import com.ahmetaliasik.taskmanagement.presentation.components.PrimaryButton
import com.ahmetaliasik.taskmanagement.ui.theme.TaskManagementTheme

@Composable
fun LetsStartView(onNavigateToHome: () -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    bitmap = ImageBitmap.imageResource(R.drawable.lets_talk_view_image),
                    contentDescription = "Let's talk",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxHeight(0.6f)
                        .fillMaxWidth()
                )
                Text(
                    text = "Task Management & To-Do List",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "This productive tool is designed to help you better manage your task project-wise conveniently!",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.secondary,
                )
                Spacer(modifier = Modifier.height(40.dp))
                PrimaryButton(
                    text = "Let's Start",
                    onClick = onNavigateToHome,
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(52.dp),
                    trailing = {
                        Image(
                            painter = painterResource(R.drawable.arrow_right),
                            contentDescription = "Arrow right",
                            modifier = Modifier.size(24.dp),
                            colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onPrimary)
                        )
                    },
                    buttonType = PrimaryButtonType.Primary,
                    fontSize = 19.sp,
                )

            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun LetsStratViewPreview() {
    TaskManagementTheme {
        LetsStartView(onNavigateToHome = {})
    }
}