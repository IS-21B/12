package com.example.smartlab.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Textbox(modifier: Modifier = Modifier, placeholderText: String) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = text,
        placeholder = { Text(text = placeholderText, color = Color.LightGray) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        onValueChange = { it ->
            text = it
        },
        shape = RoundedCornerShape(4.dp),

    )
}

@Preview
@Composable
private fun TextboxPreview() {
    Textbox(Modifier, "example@mail.ru")
}