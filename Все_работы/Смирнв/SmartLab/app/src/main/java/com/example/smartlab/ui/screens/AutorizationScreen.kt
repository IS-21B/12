package com.example.smartlab.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartlab.ui.components.ButtonMain
import com.example.smartlab.ui.components.ClickableDescriptionUnderButton
import com.example.smartlab.ui.components.DescriptionForButton
import com.example.smartlab.ui.components.DescriptionUnderHeader
import com.example.smartlab.ui.components.FieldToInput
import com.example.smartlab.ui.components.HeaderText
import com.example.smartlab.ui.components.ValuesAndButton
import com.example.smartlab.ui.theme.AccentColor

@Composable
fun AutorizationScreen(modifier: Modifier = Modifier, navController: NavController, index: Int) {
    var email by remember { mutableStateOf(0) }
    val desc_under_header = listOf(
        "Войдите, чтобы пользоваться функциями приложения",
        "Зарегистрируйтесь, чтобы пользоваться функциями приложения"
    )
    val desc_under_button_black = listOf(
        "Еще нет аккаунта? ",
        "Уже есть аккаунт? "
    )
    val desc_under_button_blue = listOf(
        "Зарегистрироваться",
        "Войти"
    )
    var index by remember { mutableStateOf(0) }
    key (index){
    Column(
        Modifier
            .padding(20.dp)
            .fillMaxSize()
            .background(Color.White),
    ) {
        HeaderText(
            modifier = Modifier.padding(top = 10.dp),
            text = "Добро пожаловать!")
        Spacer(Modifier.height(23.dp))
        DescriptionUnderHeader(text = desc_under_header[index])
        Spacer(Modifier.height(64.dp))
        ValuesAndButton(navController = navController)
        Spacer(Modifier.height(16.dp))
        Row(Modifier.align(Alignment.CenterHorizontally)) {
            DescriptionUnderHeader(text = desc_under_button_black[index])
            ClickableDescriptionUnderButton(text = desc_under_button_blue[index], onClick = {when (index) {0 -> index = 1; 1 -> index = 0}; Log.v("INDEX", "${index}")})
        }
    }
    }
}

@Preview
@Composable
private fun AutorizationScreenPrev() {
    AutorizationScreen(navController = rememberNavController(), index = 1)
}