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
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.ahmetaliasik.taskmanagement.R
import com.ahmetaliasik.taskmanagement.core.enum.PrimaryButtonType


@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String? = null, onClick: () -> Unit,
    fontSize: TextUnit? = null,
    buttonType: PrimaryButtonType,
    trailing: @Composable (() -> Unit)? = null,
    leading: @Composable (() -> Unit)? = null,
) {
    val containerColor = when (buttonType) {
        PrimaryButtonType.Primary -> MaterialTheme.colorScheme.primary
        PrimaryButtonType.Light -> MaterialTheme.colorScheme.onPrimary
        PrimaryButtonType.Disabled -> MaterialTheme.colorScheme.secondaryContainer
    }
    val textColor = when (buttonType) {
        PrimaryButtonType.Primary -> MaterialTheme.colorScheme.onPrimary
        PrimaryButtonType.Light -> MaterialTheme.colorScheme.primary
        PrimaryButtonType.Disabled -> MaterialTheme.colorScheme.primary
    }
    val textStyle = when (buttonType) {
        PrimaryButtonType.Primary -> MaterialTheme.typography.titleSmall
        PrimaryButtonType.Light -> MaterialTheme.typography.titleSmall
        PrimaryButtonType.Disabled -> MaterialTheme.typography.bodyLarge
    }

    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
        )
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            leading?.let { Box(modifier = Modifier.align(Alignment.CenterStart)) { it() } }
            text?.let {
                Box(modifier = Modifier.align(Alignment.Center)) {
                    Text(
                        text = it,
                        style = textStyle,
                        color = textColor,
                        fontSize = fontSize ?: textStyle.fontSize,
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
        },
        buttonType = PrimaryButtonType.Primary,
    )
}