package com.example.controls.ui.theme.Components

import android.content.res.Resources.Theme
import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smartlab.ui.layouts.Auth

@Composable
fun TextButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
) {

    Text(
        text = text,
        modifier = modifier
            .clickable { onClick() },
        color = MaterialTheme.colorScheme.primary,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
    )
}

@Preview
@Composable
private fun TextButtonPreview() {
    TextButton(text = "Текст, на который можно нажать")
}