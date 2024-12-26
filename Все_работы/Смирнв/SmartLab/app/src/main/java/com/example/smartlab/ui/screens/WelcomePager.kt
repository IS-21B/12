package com.example.smartlab.ui.screens
// класс переходника между макетами
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.smartlab.R

val headers = arrayOf(
    "Анализы",
    "Уведомления",
    "Мониторинг"
)
val descriptions = arrayOf(
    "Экспресс сбор и получение проб",
    "Вы быстро узнаете о результатах",
    "Наши врачи всегда наблюдают \n" +
            "за вашими показателями здоровья"
)
val group_image = arrayOf(
    R.drawable.group_2,
    R.drawable.group_2__1_,
    R.drawable.group_2__2_
)
val main_images = arrayOf(
    R.drawable.illustration,
    R.drawable._30_1,
    R.drawable.__2022_09_17__19_21_1
)
val widths_main_images = arrayOf(
    200.dp,
    366.dp,
    359.dp
)
val heights_main_images = arrayOf(
    200.dp,
    217.dp,
    269.dp,
)

@Composable
fun WelcomePager(navController: NavController) {
    val pagerState = rememberPagerState(pageCount = {3})

    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
//        if (pages == 0) {
//            SplashScreen(navController)
//        } else
        //        {
            LayoutScreen(
                innerPadd = PaddingValues(0.dp),
                textHeader = headers[page],
                textDescription = descriptions[page],
                idGroupPicture = group_image[page],
                idPictureUnder = main_images[page],
                sizeUnderPicWidth = widths_main_images[page],
                sizeUnderPicHeight = heights_main_images[page],
                changeActivity = fun () {navController.navigate("autorization_screen")}
            )
    }
}