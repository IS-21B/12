package com.example.smartlab.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.example.smartlab.ui.theme.textButtonColor

@Composable
fun TextButton(
    modifier: Modifier = Modifier,
    fontSize: TextUnit,
    text: String,
    onClick: () -> Unit = {}
) {
    Text(
        text = text,
        modifier = modifier
            .clickable { onClick() },
        color = textButtonColor,
        fontSize =fontSize,
        fontWeight = FontWeight.SemiBold,
    )
}