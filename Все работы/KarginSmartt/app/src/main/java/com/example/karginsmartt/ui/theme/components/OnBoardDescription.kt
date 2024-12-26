package com.example.karginSmartt.ui.theme.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.karginsmartt.ui.theme.OnboardDescriptionColor


//Описание назначения класса - OnBoardDescription отображает текст описания
//Дата создания - 23.12.2024;
//Автор создания - Каргин;
@Composable
fun OnBoardDescription(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text,
        modifier = modifier,
        color = OnboardDescriptionColor,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp
    )
}

class OnBoardDescription {

}
