package com.example.smartlab.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartlab.ui.theme.AccentColor
import com.example.smartlab.ui.theme.FocusedBorderColor
import com.example.smartlab.ui.theme.FocusedContainerColor
import com.example.smartlab.ui.theme.FocusedPlaceholderColor
import com.example.smartlab.ui.theme.UnfocusedBorderColor
import com.example.smartlab.ui.theme.UnfocusedContainerColor
import com.example.smartlab.ui.theme.UnfocusedPlaceholderColor
import org.w3c.dom.Text

@Composable
fun FieldToInput(modifier: Modifier = Modifier, label: String, placeholder: String,
                 pwdTransform: VisualTransformation, keyboard: KeyboardOptions, text: String) {
    var text by remember { mutableStateOf("") }
    Text(
        text = label,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp,
        color = Color(0xff7E7E9A)
    )
    Spacer(Modifier.height(4.dp))
    TextField(
        modifier = modifier,
        value = text,
        onValueChange = { text = it},
        placeholder = {
            Text(
                text = placeholder,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 20.sp
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = FocusedContainerColor,
            unfocusedContainerColor = UnfocusedContainerColor,
            focusedPlaceholderColor = FocusedPlaceholderColor,
            unfocusedPlaceholderColor = UnfocusedPlaceholderColor,
            focusedBorderColor = FocusedBorderColor,
            unfocusedBorderColor = UnfocusedBorderColor,
            cursorColor = AccentColor
        ),
        shape = RoundedCornerShape(10.dp),
        visualTransformation = pwdTransform,
        keyboardOptions = keyboard//KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}

@Preview
@Composable
private fun FieldToInputPrev() {
}