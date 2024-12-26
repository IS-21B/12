package com.example.smartlab.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartlab.R

@Composable
fun HeaderText(modifier: Modifier = Modifier, text: String) {
    Row {
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.emojies),
            contentDescription = "",
            modifier = Modifier.size(32.dp, 32.dp)
        )
        Spacer(Modifier.width(16.dp))
        Text(
            text = text,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 28.sp,
            //fontFamily = FontFamily.
        )
    }
}

@Preview
@Composable
private fun HeaderPrev() {
    HeaderText(text = "Добро пожаловать!")
}