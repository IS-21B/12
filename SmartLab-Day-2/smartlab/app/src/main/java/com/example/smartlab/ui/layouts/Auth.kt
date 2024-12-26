package com.example.smartlab.ui.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.ui.companents.PrimaryButton
import com.example.smartlab.R
import com.example.smartlab.ui.components.Textbox

@Composable
fun Auth(modifier: Modifier = Modifier, welcomeStr: String, descriptionString: String, navController: NavController) {
    val firaSansFamily = FontFamily(
        Font(R.font.nunito_semibold, FontWeight.SemiBold),
        Font(R.font.nunito_bold, FontWeight.Bold),
        Font(R.font.nunito, FontWeight.Black)
    )
    Column(modifier.fillMaxSize().padding(top = 55.dp, start = 35.dp, end = 35.dp, bottom = 86.dp)) {
        Row(modifier.fillMaxWidth()) {
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.emojies),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = modifier.weight(0.5f).size(30.dp)
            )
            Spacer(
                modifier = modifier.weight(0.125f)
            )
            Text(
                text = welcomeStr,
                modifier = modifier.weight(4f),
                fontSize = 24.sp,
                fontWeight = FontWeight.Black,
                fontFamily = firaSansFamily,
                letterSpacing = 0.125.sp
            )
        }
        Spacer(
            modifier = modifier.height(20.dp)
        )
        Text(
            text = descriptionString,
            fontSize = 15.sp,
            fontFamily = firaSansFamily,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 0.125.sp
        )
        Spacer(
            modifier = modifier.height(64.dp)
        )
        Text(
            text = "Вход по E-mail",
            color = Color.LightGray,
        )
        Textbox(
            modifier = modifier.fillMaxWidth(),
            placeholderText = "example@mail.ru"
        )
        Spacer(
            modifier = modifier.height(32.dp)
        )
        PrimaryButton(
            text = "Далее",
            modifier = Modifier.fillMaxWidth().size(335.dp, 56.dp),
            onClick = { navController.navigate("codeEmail") },
            enabled = true
        )

    }
}
//
//@Preview (showBackground = true)
//@Composable
//private fun AuthPreview() {
//    Auth(Modifier, "Добро пожаловать!", "Войдите, чтобы пользоваться функциями приложения")
//}