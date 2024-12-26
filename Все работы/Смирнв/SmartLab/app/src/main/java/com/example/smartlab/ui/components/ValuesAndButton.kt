package com.example.smartlab.ui.components

import android.text.TextUtils
import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartlab.ui.theme.AccentColor
import com.example.smartlab.ui.theme.ErrorBolderColor
import com.example.smartlab.ui.theme.FocusedBorderColor
import com.example.smartlab.ui.theme.FocusedContainerColor
import com.example.smartlab.ui.theme.FocusedPlaceholderColor
import com.example.smartlab.ui.theme.UnfocusedBorderColor
import com.example.smartlab.ui.theme.UnfocusedContainerColor
import com.example.smartlab.ui.theme.UnfocusedPlaceholderColor

@Composable
fun ValuesAndButton(modifier: Modifier = Modifier, navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isErrorEmail by remember { mutableStateOf(false) }
    fun validate(text: String) {
        isErrorEmail = email.length > 8
        Log.e("isErrorMAIL", "${isErrorEmail}")
    }
    key(isErrorEmail) {
        Text(
            text = "E-mail",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 20.sp,
            color = Color(0xff7E7E9A)
        )
        Spacer(Modifier.height(4.dp))
        TextField(
            maxLines = 1,
            isError = isErrorEmail,
            modifier = Modifier.fillMaxWidth(),
            value = email,
            onValueChange = { email = it; validate(email)},
            placeholder = {
                Text(
                    text = "example@mail.ru",
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
                errorBorderColor = ErrorBolderColor,
                cursorColor = AccentColor
            ),
            shape = RoundedCornerShape(10.dp),
            visualTransformation = VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Unspecified),
            supportingText = {
                if (isErrorEmail) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Limit: ${email.length}/ charLimit",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        )
        Text(
            text = "Password",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 20.sp,
            color = Color(0xff7E7E9A)
        )
        Spacer(Modifier.height(4.dp))
        TextField(
            maxLines = 1,
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = { password = it },
            placeholder = {
                Text(
                    text = "*****",
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
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

        )

        Spacer(Modifier.height(32.dp))
        ButtonMain(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            onClick = { if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) isErrorEmail = true else isErrorEmail = false;
                      navController.navigate("main_screen")
                      },
            text = "Далее",
            enabled = true,
            AccentColor,
            Color.White
        )
    }
}