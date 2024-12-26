package com.example.karginSmartt.ui.theme.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.karginsmartt.ui.theme.OnHeaderColor

//Описание назначения класса - OnBoardHeader отображает заголовочный текст
//Дата создания - 23.12.2024;
//Автор создания - Каргин;
@Composable
fun OnBoardHeader(modifier: Modifier = Modifier,text: String) {
    Text(
        text = text,
        modifier = modifier,
        color = OnHeaderColor,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
    )
}

class OnBoardHeader {

}
