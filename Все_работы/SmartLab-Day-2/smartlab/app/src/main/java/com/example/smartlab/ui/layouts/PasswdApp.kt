package com.example.smartlab.ui.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartlab.R

import com.example.smartlab.ui.components.NumberBtn


@Composable
fun PasswdApp(navController: NavController, modifier: Modifier = Modifier) {
    val buttonStates = remember { mutableStateListOf(false, false, false, false) }
    val enteredValues = remember { mutableStateListOf<String>() }

    // Проверяем состояние кнопок и выполняем переход, если все активны
    LaunchedEffect(buttonStates) {
        if (buttonStates.all { it }) {
            navController.navigate("createUser ") // Автоматический переход
        }
    }

    Column(modifier.fillMaxSize().padding(top = 84.dp, start = 25.dp, end = 20.dp, bottom = 80.dp)) {
        Row {
            Spacer(modifier.weight(1f))
            Text(
                text = "Пропустить",
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clickable { navController.navigate("createUser") }, // Переход на экран CreateUser  по нажатию
                fontSize = 15.sp,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.End
            )
        }
        Spacer(modifier.height(35.dp))
        Text(
            text = "Создайте пароль",
            modifier = modifier.align(Alignment.CenterHorizontally),
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = "Для защиты ваших персональных данных",
            modifier = modifier.align(Alignment.CenterHorizontally),
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            color = Color.Gray
        )
        Spacer(Modifier.height(56.dp))

        // Отображение изображений в зависимости от состояния
        Row(modifier.fillMaxWidth().align(Alignment.CenterHorizontally), horizontalArrangement = Arrangement.Center) {
            buttonStates.forEachIndexed { index, isActive ->
                Image(
                    bitmap = ImageBitmap.imageResource(if (isActive) R.drawable.progtrue else R.drawable.progfalse),
                    contentDescription = null,
                    modifier = modifier.size(16.dp)
                )
                Spacer(Modifier.width(12.dp))
            }
        }

        Spacer(Modifier.height(60.dp))
        Box(modifier.padding(start = 25.dp, end = 26.dp).size(288.dp, 340.dp)) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    NumberBtn("1", Modifier.weight(1f), onClick = { handleNumberClick(1, buttonStates, enteredValues) }) // 1
                    NumberBtn("2", Modifier.weight(1f), onClick = { handleNumberClick(2, buttonStates, enteredValues) }) // 2
                    NumberBtn("3", Modifier.weight(1f), onClick = { handleNumberClick(3, buttonStates, enteredValues) }) // 3
                }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    NumberBtn("4", Modifier.weight(1f), onClick = { handleNumberClick(4, buttonStates, enteredValues) }) // 4
                    NumberBtn("5", Modifier.weight(1f), onClick = { handleNumberClick(5, buttonStates, enteredValues) }) // 5
                    NumberBtn("6", Modifier.weight(1f), onClick = { handleNumberClick(6, buttonStates, enteredValues) }) // 6
                }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    NumberBtn("7", Modifier.weight(1f), onClick = { handleNumberClick(7, buttonStates, enteredValues) }) // 7
                    NumberBtn("8", Modifier.weight(1f), onClick = { handleNumberClick(8, buttonStates, enteredValues) }) // 8
                    NumberBtn("9", Modifier.weight(1f), onClick = { handleNumberClick(9, buttonStates, enteredValues) }) // 9
                }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    NumberBtn("0", Modifier.weight(1f), onClick = { handleNumberClick(0, buttonStates, enteredValues) }) // 0
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.del_icon),
                        contentDescription = null,
                        modifier = Modifier.size(48.dp) // Укажите размер изображения
                            .weight(1f)
                            .align(Alignment.CenterVertically) // Центрируем изображение по вертикали
                            .clickable { clearLastEnteredValue(buttonStates, enteredValues) } // Обработчик нажатия
                    )
                }
            }
        }
    }
}

// Обработчик нажатия на номер
private fun handleNumberClick(number: Int, buttonStates: MutableList<Boolean>, enteredValues: MutableList<String>) {
    // Добавляем введенное значение в список
    if (number in 0..9) {
        enteredValues.add(number.toString())
        // Изменяем состояние 4 изображений в зависимости от введенного значения
        updateButtonStates(buttonStates, enteredValues.size)
    }
}

// Функция для обновления состояния изображений
private fun updateButtonStates(buttonStates: MutableList<Boolean>, count: Int) {
    // Сбрасываем все состояния
    buttonStates.fill(false)
    // Устанавливаем состояния для первых 4 изображений
    for (i in 0 until minOf(count, buttonStates.size)) {
        buttonStates[i] = true
    }
}

// Функция для удаления последнего введенного значения
private fun clearLastEnteredValue(buttonStates: MutableList<Boolean>, enteredValues: MutableList<String>) {
    if (enteredValues.isNotEmpty()) {
        enteredValues.removeAt(enteredValues.lastIndex) // Удаляем последнее введенное значение
        // Обновляем состояния изображений
        updateButtonStates(buttonStates, enteredValues.size)
    }
}

//@Preview (showBackground = true)
//@Composable
//private fun PasswdAppPreview() {
//    PasswdApp(Modifier)
//}