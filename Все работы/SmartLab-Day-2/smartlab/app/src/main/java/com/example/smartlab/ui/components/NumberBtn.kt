package com.example.smartlab.ui.components

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartlab.ui.theme.AccentInactiveColor

@Composable
fun NumberBtn(
    text: String,
    navController: Modifier, // Добавляем navController
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    // Состояние для отслеживания нажатия кнопки
    val isPressed = remember { mutableStateOf(false) }

    Button(
        onClick = {
            onClick() // Вызываем переданный обработчик нажатия
        },
        modifier = modifier
            .size(85.dp)
            .pointerInput(Unit) {
                this.detectTapGestures(
                    onPress = {
                        isPressed.value = true // Устанавливаем состояние нажатия
                        tryAwaitRelease() // Ожидаем, пока палец не будет поднят
                        isPressed.value = false // Сбрасываем состояние нажатия
                    }
                )
            },
        enabled = enabled,
        shape = RoundedCornerShape(150.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = if (isPressed.value) Color.Blue else Color.LightGray,
            disabledContainerColor = AccentInactiveColor,
            disabledContentColor = Color.White
        )
    ) {
        Text(
            text = text,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 24.sp
        )
    }
}

//@Preview (showBackground = true)
//@Composable
//private fun NumberBtnPreview() {
//    NumberBtn(
//        "1", Modifier,
//        onClick = TODO(),
//        enabled = true,
//    )
//}