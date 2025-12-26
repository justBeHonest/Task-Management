package com.ahmetaliasik.taskmanagement.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmetaliasik.taskmanagement.R

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String? = null, onClick: () -> Unit,
    lightButton: Boolean = false,
    trailing: @Composable (() -> Unit)? = null,
    leading: @Composable (() -> Unit)? = null,
) {
    val containerColor =
        if (lightButton) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary
    val textColor =
        if (lightButton) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary
    val textStyle =
        if (lightButton) MaterialTheme.typography.titleSmall else MaterialTheme.typography.headlineSmall
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
        )
    ) {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center
        ) {
            leading?.let { Box(modifier = Modifier.align(Alignment.CenterStart)) { it() } }
            text?.let {
                Box(modifier = Modifier.align(Alignment.Center)) {
                    Text(
                        text = it,
                        style = textStyle,
                        color = textColor,
                    )
                }
            }
            trailing?.let { Box(modifier = Modifier.align(Alignment.CenterEnd)) { it() } }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PrimaryButtonPreview() {
    PrimaryButton(
        text = "Let's Start", onClick = {},
        trailing = {
            Image(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = "Arrow right",
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary)
            )
        })
}