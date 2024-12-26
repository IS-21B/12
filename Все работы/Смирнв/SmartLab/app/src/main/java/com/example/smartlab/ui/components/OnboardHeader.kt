package com.example.smartlab.ui.components
/* Класс заголовка */
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.smartlab.ui.theme.TitleMainColor

@Composable
fun OnboardHeader(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text,
        modifier = modifier,
        color = TitleMainColor,
        fontWeight = FontWeight(600),
        fontSize = 20.sp,
        lineHeight = 28.sp
    )
}

@Preview
@Composable
private fun OnboardHeaderPreview() {
    OnboardHeader(modifier = Modifier, "Заголовок")
}