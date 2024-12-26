package com.example.smartlab.ui.layouts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.companents.PrimaryButton
import com.example.smartlab.ui.components.GenderDropdown
import com.example.smartlab.ui.components.Textbox

@Composable
fun CreateUser(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize().padding(top = 84.dp, start = 20.dp, end = 20.dp, bottom = 80.dp)) {
        Row(modifier.fillMaxWidth()) {
            Text(
                text = "Создание карты \nпациента",
                fontSize = 24.sp
            )
            Text(
                text = "Пропустить",
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clickable { },
                fontSize = 15.sp,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.End
            )
        }
        Spacer(Modifier.height(20.dp))
        Text(
            text = "Без карты пациента вы не сможете заказать анализы.",
            fontSize = 14.sp,
            color = Color.LightGray
        )
        Text(
            text = "В картах пациентов будут храниться результаты анализов вас и ваших близких.",
            fontSize = 14.sp,
            color = Color.LightGray
        )
        Spacer(Modifier.height(20.dp))
        Textbox(Modifier, "Имя")
        Spacer(Modifier.height(24.dp))
        Textbox(Modifier, "Отчество")
        Spacer(Modifier.height(24.dp))
        Textbox(Modifier, "Фамилия")
        Spacer(Modifier.height(24.dp))
        Textbox(Modifier, "Дата рождения")
        Spacer(Modifier.height(24.dp))
        GenderDropdown()
        Spacer(Modifier.height(48.dp))
        PrimaryButton("Далее", Modifier.fillMaxWidth(), onClick = {}, true)
    }
}

@Preview (showBackground = true)
@Composable
private fun CreateUserPreview() {
    CreateUser(Modifier)
}