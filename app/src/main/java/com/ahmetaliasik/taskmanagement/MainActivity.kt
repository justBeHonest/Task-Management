package com.ahmetaliasik.taskmanagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ahmetaliasik.taskmanagement.presentation.letsstart.LetsStartView
import com.ahmetaliasik.taskmanagement.presentation.navigation.AppNavigation
import com.ahmetaliasik.taskmanagement.ui.theme.TaskManagementTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagementTheme {
                AppNavigation()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagementTheme {
        LetsStartView(onNavigateToHome = {})
    }
}