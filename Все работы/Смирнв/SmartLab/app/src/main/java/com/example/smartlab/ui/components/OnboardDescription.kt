package com.example.smartlab.ui.components
/* Класс описания */
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.smartlab.ui.theme.OnboardDescriptionColor

@Composable
fun  OnboardDescription(modifier: Modifier = Modifier, description: String) {
    Text(
        text = description,
        modifier = modifier,
        color =  OnboardDescriptionColor,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp
    )
}

@Preview
@Composable
private fun OnboardDescriptionPreview() {
    OnboardDescription(modifier = Modifier, "description")
}