package com.example.karginsmartt.ui.theme.scrins

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.karginsmartt.R
import com.example.karginsmartt.ui.theme.AccentColor
import com.example.karginsmartt.ui.theme.InputBGColor
import com.example.karginsmartt.ui.theme.InputFocusBorder
import com.example.karginsmartt.ui.theme.InputString
import com.example.karginsmartt.ui.theme.components.PrimaryButton


@Composable
fun OnAvtoTwo(modifier: Modifier = Modifier, onClick: () -> Unit, onRegisterClickTwo: () -> Unit,onNavigateBack: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                top = 59.dp,
                start = 20.dp,
                end = 20.dp,
                bottom = 56.dp
            )
    ) {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var isValidEmail by remember { mutableStateOf(false) }
        val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}\$")
        var isPasswordVisible by remember { mutableStateOf(false) }

        Spacer(Modifier.size(59.dp))

        Row {
            Image(
                ImageBitmap.imageResource(R.drawable.emojies),
                null,
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp)
            )
            Spacer(Modifier.width(16.dp))

            Text(
                text = "Добро пожаловать!",
                fontSize = 24.sp,
                fontWeight = FontWeight(700),
                lineHeight = 29.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(Modifier.size(20.dp))

        Text(
            text = "Зарегистрируйтесь, чтобы пользоваться функциями приложения",
            fontSize = 15.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight(400)
        )
        Spacer(Modifier.size(64.dp))

        Text(
            text = "Вход по E-mail",
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight(400),
            color = Color(0xFF7E7E9A)
        )
        Spacer(Modifier.height(4.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { newValue ->
                email = newValue
                isValidEmail = emailRegex.matches(newValue)
            },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),

            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),

            enabled = true,
            readOnly = false,

            placeholder = {
                Text(
                    text = "example@mail.ru",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 20.sp
                )
            },

            textStyle = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 20.sp
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = InputBGColor,
                unfocusedContainerColor = InputBGColor,
                focusedPlaceholderColor = Color.Black.copy(alpha = 0.5f),
                unfocusedPlaceholderColor = Color.Black.copy(alpha = 0.5f),
                focusedBorderColor = InputFocusBorder,
                unfocusedBorderColor = InputString,
                cursorColor = AccentColor
            ),
            shape = RoundedCornerShape(10.dp)
        )
        Spacer(Modifier.size(16.dp))

        Text(
            text = "Password",
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight(400),
            color = Color(0xFF7E7E9A)
        )
        Spacer(Modifier.height(4.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { newValue -> password = newValue },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),

            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),

            enabled = true,
            readOnly = false,
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),

            placeholder = {
                Text(
                    text = "*****",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 20.sp
                )
            },

            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        imageVector = if (isPasswordVisible) Icons.Filled.Check else Icons.Filled.Close,
                        contentDescription = if (isPasswordVisible) "Скрыть пароль" else "Показать пароль"
                    )
                }
            },

            textStyle = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 20.sp
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = InputBGColor,
                unfocusedContainerColor = InputBGColor,
                focusedPlaceholderColor = Color.Black.copy(alpha = 0.5f),
                unfocusedPlaceholderColor = Color.Black.copy(alpha = 0.5f),
                focusedBorderColor = InputFocusBorder,
                unfocusedBorderColor = InputString,
                cursorColor = AccentColor
            ),
            shape = RoundedCornerShape(10.dp)
        )
        Spacer(Modifier.size(32.dp))

        PrimaryButton(
            onClick = { onNavigateBack() },
            text = "Далее",
            Enable = isValidEmail && password.isNotEmpty(),
            modifier = Modifier
                .fillMaxWidth(1f)
                .height(56.dp)
        )


        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalArrangement = Arrangement.Center) {

            Text(text = "Ещё нет аккаунта?", fontSize = 14.sp, fontWeight = FontWeight.Normal)
            Spacer(Modifier.width(8.dp))
            Text(text = "Войти",
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF1A6FEE),
                modifier = Modifier.clickable {
                    onRegisterClickTwo()
                }
            )
        }

    }
}
