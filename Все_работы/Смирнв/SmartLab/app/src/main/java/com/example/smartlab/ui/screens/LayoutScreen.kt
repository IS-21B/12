package com.example.smartlab.ui.screens
/* Это класс для сбора элементов в единый макет */
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.smartlab.R
import com.example.smartlab.ui.components.OnboardDescription
import com.example.smartlab.ui.components.OnboardHeader
import com.example.smartlab.ui.components.TextButton

@Composable
fun LayoutScreen(modifier: Modifier = Modifier, sizeUnderPicHeight: Dp, changeActivity: () -> Unit = {}, sizeUnderPicWidth: Dp, innerPadd: PaddingValues, textHeader: String, textDescription: String, idPictureUnder: Int, idGroupPicture: Int) {
    Column(
        modifier = Modifier.fillMaxSize().padding(innerPadd).background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.fillMaxWidth().padding(top = 5.dp)) {
            TextButton(
                modifier = Modifier.padding(start = 30.dp),
                text = "Пропустить",
                onClick = changeActivity
            )
            Spacer(Modifier.weight(1f))
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.shape),
                contentDescription = "",
                Modifier.size(165.dp)
            )
        }
        Spacer(Modifier.height(60.dp))
        OnboardHeader(
            text = textHeader
        )
        Spacer(Modifier.height(30.dp))
        OnboardDescription(
            description = textDescription
        )
        Spacer(Modifier.height(60.dp))
        Image(
            bitmap = ImageBitmap.imageResource(idGroupPicture),
            contentDescription = "",
            Modifier.size(width = 58.dp, height = 15.dp)
        )
        Spacer(Modifier.height(105.dp))
        Image(
            bitmap = ImageBitmap.imageResource(idPictureUnder),
            contentDescription = "",
            Modifier.size(width = sizeUnderPicWidth, height = sizeUnderPicHeight)
        )
    }
}

@Preview
@Composable
private fun LayoutScreenPrev() {
    LayoutScreen(
        modifier = Modifier.fillMaxSize(),
        innerPadd = PaddingValues(10.dp),
        textHeader = "Анализы",
        textDescription = "Экспресс сбор и получение проб",
        idGroupPicture = R.drawable.group_2,
        idPictureUnder = R.drawable.illustration,
        sizeUnderPicWidth = 200.dp,
        sizeUnderPicHeight = 200.dp,
        changeActivity = fun () {}
    )
}