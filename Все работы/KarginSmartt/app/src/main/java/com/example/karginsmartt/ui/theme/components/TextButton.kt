package com.example.karginSmartt.ui.theme.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.karginsmartt.ui.theme.OnButtonColor
import com.example.karginsmartt.ui.theme.OnboardButton

//Описание назначения класса - TextButton создает стилизованный текстовый элемент, который используется как кнопку
//Дата создания - 23.12.2024;
//Автор создания - Каргин;
@Composable
fun TextButton(modifier: Modifier = Modifier, fonSize: TextUnit, text: String, onClick: () -> Unit = {}) {
    Text(
        text = text,
        modifier = modifier
            .clickable { onClick() },
        color = OnButtonColor,
        fontSize = fonSize,
        fontWeight = FontWeight.SemiBold,
    )
}

class TextButton {

}
