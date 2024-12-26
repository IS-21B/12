package com.example.karginsmartt.ui.theme.scrins

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.karginsmartt.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.toSize
import com.example.karginsmartt.ui.theme.AccentColor
import com.example.karginsmartt.ui.theme.InputBGColor
import com.example.karginsmartt.ui.theme.InputFocusBorder
import com.example.karginsmartt.ui.theme.InputString
import com.example.karginsmartt.ui.theme.components.PrimaryButton

@Composable
fun OnAvto(modifier: Modifier=Modifier,onClick: () -> Unit, onRegisterClick: () -> Unit) {
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
                        text = "Войдите, чтобы пользоваться функциями приложения",
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

                    TextField(
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
                        color =Color(0xFF7E7E9A)
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
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = InputBGColor,
                            unfocusedContainerColor = InputBGColor,
                            focusedPlaceholderColor = Color.Black.copy(alpha = 0.5f),
                            unfocusedPlaceholderColor = Color.Black.copy(alpha = 0.5f),
                            focusedBorderColor = InputFocusBorder,
                            unfocusedBorderColor = InputString,
                            cursorColor = AccentColor
                        ),

                        enabled = true,
                        readOnly = false,
                        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),

                        placeholder = {
                            Text(
                                text = "*****",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Normal,
                                lineHeight = 20.sp,
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

                        shape = RoundedCornerShape(10.dp)
                    )
                    Spacer(Modifier.size(32.dp))

                    PrimaryButton(
                        onClick = {onClick() },
                        text = "Далее",
                        Enable = isValidEmail && password.isNotEmpty(),
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .height(56.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Ещё нет аккаунта?",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(text = "Зарегистрироваться",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF1A6FEE),
                            modifier = Modifier
                                .clickable {
                                    onRegisterClick()
                            })
                    }
                }
}

@Composable
fun EmailSocdati(navController: NavController, onNavigateBack: () -> Unit) {
    val predefinedCode = "123456" // Определенный код для входа
    var codeValues by remember { mutableStateOf(List(6) { "" }) }
    var currentFocusIndex by remember { mutableStateOf(0) }
    var timer by remember { mutableStateOf(60) }
    var navigateToNextScreen by remember { mutableStateOf(false) }

    // Запускаем таймер
    LaunchedEffect(timer) {
        if (timer > 0) {
            while (timer > 0) {
                delay(1000)
                timer--
            }
        } else {
            timer = 60 // Сброс таймера, если он достиг нуля
        }
    }

    // Проверяем введенный код
    val enteredCode = codeValues.joinToString("")
    LaunchedEffect(enteredCode) {
        if (enteredCode.length == 6 && enteredCode == predefinedCode) { // Сравниваем с заранее заданным кодом
            delay(2000)
            navigateToNextScreen = true
        }
    }

    // Переход на следующий экран
    if (navigateToNextScreen) {
        navController.navigate("creaturepassword")
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            IconButton(onClick = onNavigateBack, modifier = Modifier.padding(top = 68.dp)) {
                Image(
                    ImageBitmap.imageResource(R.drawable.back), contentDescription = "Назад",
                    modifier = Modifier
                        .width(32.dp)
                        .height(32.dp)
                )
            }
            Spacer(modifier = Modifier.height(132.dp))
            Text(text = "Введите код из E-mail", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Ваш код: $predefinedCode", // Отображаем заранее заданный код
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                codeValues.forEachIndexed { index, value ->
                    TextField(
                        value = value,
                        onValueChange = { newValue ->
                            if (newValue.length <= 1 && newValue.all { it.isDigit() }) {
                                val updatedCode = codeValues.toMutableList()
                                updatedCode[index] = newValue
                                codeValues = updatedCode
                                if (newValue.isNotEmpty() && index < 5) {
                                    currentFocusIndex++
                                }
                            }
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.width(48.dp),
                        singleLine = true,
                        textStyle = TextStyle(textAlign = TextAlign.Center),
                        shape = RoundedCornerShape(8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Отправить код повторно можно \n будет через $timer секунд",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color(0xFF939396)
            )
        }
    }
}


    @Composable
    fun Password(modifier: Modifier=Modifier,onSkip: () -> Unit, onCreate: (String) -> Unit) {
        var password by remember { mutableStateOf("") }
        val passwordPoints = remember { mutableStateListOf(false, false, false, false) }
        val coroutineScope = rememberCoroutineScope()

        Column(
            modifier = Modifier
                .padding(end = 20.dp, top = 84.dp, start = 20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(onClick = onSkip) {
                    Text("Пропустить", fontWeight = FontWeight.SemiBold, color = Color(0xFF1A6FEE))
                }
            }
            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Создайте пароль",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Для защиты ваших персональных данных",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color =Color(0xFF939396),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(56.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                passwordPoints.forEachIndexed { index, point ->
                    val color = if (point) Color(0xFF1A6FEE) else Color.LightGray
                    Box(
                        modifier = Modifier
                            .size(16.dp)
                            .background(color = color, shape = CircleShape)
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            val buttonColors = remember { mutableStateListOf(*Array(10) { Color.White }) }
            val buttonLayout = listOf(
                listOf(1, 2, 3),
                listOf(4, 5, 6),
                listOf(7, 8, 9),
                listOf(0)
            )
            buttonLayout.forEachIndexed { rowIndex, row ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    row.forEachIndexed { index, number ->
                        if (rowIndex == buttonLayout.lastIndex && index == 0) {
                            Spacer(modifier = Modifier.weight(1f))
                        }

                        Button(
                            onClick = {
                                if (password.length < 4) {
                                    password += number.toString()
                                    passwordPoints[password.length - 1] = true
                                    buttonColors[number] = Color(0xFF1A6FEE)

                                    coroutineScope.launch {
                                        delay(100)
                                        buttonColors[number] = Color.Gray
                                    }
                                }
                            },
                            modifier = Modifier.size(72.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = buttonColors[number]),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text(
                                text = number.toString(),
                                fontSize = 24.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black
                            )
                        }

                        if (rowIndex == buttonLayout.lastIndex && index == 0) {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                    Spacer(modifier = Modifier.height(26.dp))
                    if (rowIndex == buttonLayout.lastIndex) {
                        Image(
                            bitmap = ImageBitmap.imageResource(R.drawable.del_icon),
                            contentDescription = "Backspace",
                            alignment = Alignment.TopEnd,
                            modifier = Modifier
                                .size(55.dp)
                                .padding(end = 5.dp)
                                .clickable {
                                    if (password.isNotEmpty()) {
                                        password = password.dropLast(1)
                                        passwordPoints[password.length] = false
                                    }
                                }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (password.length == 4) {
                        onCreate(password)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1A6FEE),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp),
                enabled = password.length == 4
            ) {
                Text(
                    text = "Создать",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }

    @Composable
    fun Patient(onSkip: () -> Unit, onCreate: () -> Unit) {
        var name by remember { mutableStateOf("") }
        var surname by remember { mutableStateOf("") }
        var patronymic by remember { mutableStateOf("") }
        var birthDate by remember { mutableStateOf("") }
        var gender by remember { mutableStateOf("") }
        var expanded by remember { mutableStateOf(false) }
        var textFieldSize by remember { mutableStateOf(Size.Zero) }
        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 20.dp, top = 76.dp, start = 20.dp)
                .verticalScroll(scrollState)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),

                ) {
                Text(
                    text = "Создание карты \n пациента",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(12.dp))
                TextButton(onClick = onSkip) {
                    Text(
                        text = "Пропустить",
                        fontWeight= FontWeight.SemiBold,
                        color = Color(0xFF1A6FEE)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Без карты пациента вы не сможете заказать \n анализы.",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFF939396)
            )
            Spacer(modifier = Modifier.height(1.dp))

            Text(
                text = "В картах пациентов будут храниться результаты \n анализов вас и ваших близких.",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFF939396)
            )
            Spacer(modifier = Modifier.height(20.dp))


            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Имя", fontWeight = FontWeight.SemiBold) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            TextField(
                value = surname,
                onValueChange = { surname = it },
                label = { Text("Отчество", fontWeight = FontWeight.SemiBold) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))

            TextField(
                value = patronymic,
                onValueChange = { patronymic = it },
                label = { Text("Фамилия", fontWeight = FontWeight.SemiBold) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))

            TextField(
                value = birthDate,
                onValueChange = { birthDate = it },
                label = { Text("Дата рождения", fontWeight = FontWeight.SemiBold) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))

            TextField(
                value = gender,
                onValueChange = { gender = it },
                label = { Text("Пол", fontWeight = FontWeight.SemiBold) },
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        textFieldSize = coordinates.size.toSize()
                    },
                trailingIcon = {
                    Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = null,
                        Modifier.clickable { expanded = !expanded } )
                },
                readOnly = true,
                shape = RoundedCornerShape(8.dp)
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.width(with(LocalDensity.current) { textFieldSize.width.toDp() })
            ) {
                DropdownMenuItem(
                    text = { Text("мужской", fontWeight = FontWeight.SemiBold) },
                    onClick = {
                        gender = "мужской"
                        expanded = false
                    })
                DropdownMenuItem(
                    text = { Text("женский", fontWeight = FontWeight.SemiBold) },
                    onClick = {
                        gender = "женский"
                        expanded = false
                    })
            }


            Spacer(modifier = Modifier.height(48.dp))

            Button(
                onClick = onCreate,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1A6FEE),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Создать",
                    fontSize = 17.sp,
                    fontWeight =FontWeight.SemiBold
                )
            }
        }
    }

