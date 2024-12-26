package com.example.smartlab.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.smartlab.ui.theme.BlueBackGround

@Composable
fun ClickableDescriptionUnderButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit = {} ) {
    Text(
        modifier = Modifier.clickable { onClick() },
        text = text,
        fontSize = 15.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp,
        color = BlueBackGround
    )
}