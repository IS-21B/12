package com.example.smartlab.ui.layouts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.controls.ui.theme.Components.TextButton
import com.example.myapplication.ui.companents.OnboardDescription
import com.example.myapplication.ui.companents.OnboardHeader
import com.example.smartlab.R

@Composable
fun Onboard(modifier: Modifier = Modifier, ButtonText: String, HeaderText: String, DescriptionText: String, navController: NavController) {

    val imagesAndText = remember {
        listOf(
            Pair(R.drawable.group_2, "Анализы"),
            Pair(R.drawable.group_2__1_, "Уведомление"),
            Pair(R.drawable.group_2__2_, "Мониторинг")
        )
    }
    val pagerState = rememberPagerState(pageCount = {imagesAndText.size})
    HorizontalPager(
        state = pagerState,
        modifier = modifier.fillMaxSize()
    ) {
        page ->
        val (imageRes, text) = imagesAndText[page]
    }
    Column(Modifier.fillMaxSize().padding(top = 50.dp, start = 15.dp, end = 15.dp, bottom = 86.dp)) {
        val ButtonText = if (pagerState.currentPage == 2) "Завершить" else "Пропустить"
        val HeaderText = if (pagerState.currentPage == 2) "Мониторинг" else if (pagerState.currentPage == 1) "Уведомление" else "Анализы"
        val DescriptionText = if (pagerState.currentPage == 2) "Наши врачи всегда наблюдают за вашими показателями здоровья" else if (pagerState.currentPage == 1) "Вы быстро узнаете о результатах" else "Экспресс сбор и получение проб"
        Row  {
            TextButton(
                text = ButtonText,
                modifier = Modifier.weight(1f),
                onClick = { navController.navigate("Auth") }
            )
            Spacer(
                modifier = Modifier.weight(1f)
            )
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.image_add),
                contentDescription = null,
                modifier = Modifier.weight(1f)
            )

        }
        Spacer(
            modifier = Modifier.height(61.dp)
        )
        OnboardHeader(
            text = HeaderText,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(
            modifier = Modifier.height(29.dp)
        )
        OnboardDescription(
            text = DescriptionText,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(
            modifier = Modifier.height(60.dp)
        )
        Image(
            imageVector = if (pagerState.currentPage == 2) ImageVector.vectorResource(R.drawable.group_2__2_) else if (pagerState.currentPage == 1) ImageVector.vectorResource(R.drawable. group_2__1_) else ImageVector.vectorResource(R.drawable. group_2),
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.weight(1f))
        Image(
            bitmap = if (pagerState.currentPage == 2) ImageBitmap.imageResource(R.drawable.image_3) else if (pagerState.currentPage == 1) ImageBitmap.imageResource(R.drawable.image_1) else ImageBitmap.imageResource(R.drawable.image_2),
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterHorizontally).size(250.dp)
        )
    }
}

//@Preview
//@Composable
//private fun OnboardPreview() {
//    Onboard(Modifier,"Пропустить", "Анализы", "Экспресс сбор и получение проб", navController: NavController)
//}