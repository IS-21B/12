package com.example.smartlab.layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartlab.components.OnBoardDescription
import com.example.smartlab.components.PrimaryButton
import com.example.smartlab.components.TextButton
import com.example.smartlab.components.TextInput

@Composable
fun PatientCard(modifier: Modifier = Modifier, OnClick: () -> Unit, navController: NavController) {
    var name by remember { mutableStateOf("") }
    var patronymic by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("") }

    Column(modifier = modifier.padding(top = 60.dp, end = 20.dp, start = 20.dp, bottom = 20.dp)) {
        Row() {
            Text(
                text = "Создание карты \nпациента",
                lineHeight = 28.sp,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(1f)
            )
            TextButton(
                text = "Пропустить",
                onClick = { OnClick() },
                fontSize = 15.sp,
                modifier = Modifier.padding(top = 8.dp, end = 0.dp, start = 0.dp, bottom = 0.dp)
            )
        }
        Spacer(modifier.height(16.dp))
        OnBoardDescription(
            text = "Без карты пациента вы не сможете заказать анализы.\n" +
                    "В картах пациентов будут храниться результаты анализов вас и ваших близких."
        )
        Spacer(modifier.height(20.dp))

        TextInput(
            placeholder = "Имя",
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {name})
        Spacer(modifier.height(24.dp))

        TextInput(
            modifier = Modifier.fillMaxWidth(),
            placeholder = "Отчество",
            onValueChange = {patronymic})
        Spacer(modifier.height(24.dp))

        TextInput(
            modifier = Modifier.fillMaxWidth(),
            placeholder = "Фамилия",
            onValueChange = {surname})
        Spacer(modifier.height(24.dp))

        TextInput(
            modifier = Modifier.fillMaxWidth(),
            placeholder = "Дата рождения",
            onValueChange = {dateOfBirth})
        Spacer(modifier.height(24.dp))

        Spacer(modifier.height(48.dp))

        PrimaryButton(
            onClick = { OnClick() },
            text = "Создать",
            Enable = name.isNotEmpty() && patronymic.isNotEmpty() && surname.isNotEmpty() && dateOfBirth.isNotEmpty(),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )
    }
}

@Preview
@Composable
private fun PatientCardPrev() {

}