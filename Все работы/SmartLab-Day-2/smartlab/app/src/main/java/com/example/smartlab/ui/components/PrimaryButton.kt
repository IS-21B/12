package com.example.myapplication.ui.companents

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartlab.ui.theme.AccentColor
import com.example.smartlab.ui.theme.AccentInactiveColor

@Composable
fun PrimaryButton(text: String, modifier: Modifier = Modifier,onClick: () ->Unit, enabled: Boolean = true) {
    Button(
        onClick = {onClick()},
        modifier = modifier,
        enabled = enabled,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = AccentColor,
            disabledContainerColor = AccentInactiveColor,
            disabledContentColor = Color.White
        )
    ) { Text(
        text = text,
        fontSize = 17.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 24.sp ) }

}