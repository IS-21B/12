package com.example.smartlab.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenderDropdown(
    modifier: Modifier = Modifier,
    placeholderText: String = "Выберите пол"
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedGender by remember { mutableStateOf("") }
    val genders = listOf("Мужской", "Женский")

    // Обертка для выпадающего меню
    ExposedDropdownMenuBox(
        modifier = modifier.fillMaxWidth(),
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        // Текстовое поле для отображения выбранного значения
        TextField(
            readOnly = true,
            value = selectedGender,
            onValueChange = {},
            placeholder = { Text(text = placeholderText, color = Color.LightGray) },
            trailingIcon = {
                Icon(Icons.Default.ArrowDropDown, contentDescription = null)
            },
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )

        // Выпадающее меню с вариантами
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            genders.forEach { gender ->
                DropdownMenuItem(
                    onClick = {
                        selectedGender = gender
                        expanded = false
                    },
                    text = { Text(text = gender) }, // Передаем текст
                    modifier = Modifier.fillMaxWidth(), // Указываем модификатор
                    leadingIcon = null, // Можно добавить иконку, если нужно
                    trailingIcon = null, // Можно добавить иконку, если нужно
                    enabled = true, // Возможно, вы хотите сделать это динамическим
                    contentPadding = PaddingValues(16.dp) // Указываем отступы
                )

            }
        }
    }
}

@Preview
@Composable
fun GenderDropdownPreview() {
    GenderDropdown()
}
