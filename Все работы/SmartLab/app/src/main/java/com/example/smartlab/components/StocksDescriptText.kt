package com.example.smartlab.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.smartlab.R

@Composable
fun StocksDescriptText(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text,
        modifier = modifier,
        color = Color.White,
        fontSize = 14.sp,
        fontWeight = FontWeight.W400,
        lineHeight = 20.sp,
    )
}