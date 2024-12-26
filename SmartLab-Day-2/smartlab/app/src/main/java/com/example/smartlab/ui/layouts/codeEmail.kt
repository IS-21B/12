package com.example.smartlab.ui.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.ui.companents.PrimaryButton
import com.example.smartlab.R
import com.example.smartlab.ui.components.Textbox
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun CodeEmail(modifier: Modifier = Modifier, navController: NavController) {
    val firaSansFamily = FontFamily(
        Font(R.font.nunito_semibold, FontWeight.SemiBold),
        Font(R.font.nunito_bold, FontWeight.Bold),
        Font(R.font.nunito, FontWeight.Black)
    )
    Column(modifier.fillMaxSize().padding(top = 68.dp, start = 20.dp, end = 20.dp, bottom = 100.dp), verticalArrangement = Arrangement.Center) {
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.back),
            contentDescription = null,
            modifier = modifier.size(35.dp)
                .clickable { navController.navigate("passwdApp") }
        )
        Spacer(modifier = modifier.height(120.dp))
        Text(
            text = "Введите код из E-mail",
            modifier = modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontFamily = firaSansFamily,
        )
        Spacer(modifier = modifier.height(20.dp))
        Row (modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Textbox(modifier=modifier.size(42.dp, 48.dp), "")
            Spacer(modifier = modifier.width(16.dp))
            Textbox(modifier=modifier.size(42.dp, 48.dp), "")
            Spacer(modifier = modifier.width(16.dp))
            Textbox(modifier=modifier.size(42.dp, 48.dp), "")
            Spacer(modifier = modifier.width(16.dp))
            Textbox(modifier=modifier.size(42.dp, 48.dp), "")
            Spacer(modifier = modifier.width(16.dp))
            Textbox(modifier=modifier.size(42.dp, 48.dp), "")
            Spacer(modifier = modifier.width(16.dp))
            Textbox(modifier=modifier.size(42.dp, 48.dp), "")
        }
        Spacer(modifier = modifier.height(20.dp))
        Text(
            text = "Отправить код повторно можно \n будет через 42 секунд",
            modifier = modifier.fillMaxSize().size(15.dp),
            color = Color.LightGray,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            fontFamily = firaSansFamily,
        )
    }
}