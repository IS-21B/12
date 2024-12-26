package com.example.smartlab.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.smartlab.ui.theme.AccentColor

@Composable
fun DescriptionUnderHeader(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text,
        fontSize = 15.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp,
        color = Color.Black
    )
}

@Preview
@Composable
private fun DescriptionUnderHeaderPrev() {
    DescriptionUnderHeader(text = "description")
}