package com.example.smartlab.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smartlab.R
import com.example.smartlab.layouts.Authorization
import com.example.smartlab.layouts.AuthorizationTwo
import com.example.smartlab.layouts.CodeConfirmation
import com.example.smartlab.layouts.CreatePassword
import com.example.smartlab.layouts.MainScreen
import com.example.smartlab.layouts.OnBoard
import com.example.smartlab.layouts.PatientCard

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "main"){
        composable("main") {
            val pagerState = rememberPagerState(pageCount = {
                3
            })

            HorizontalPager(state = pagerState) { page ->
                if (page == 0) {
                    OnBoard(
                        buttomText = "Пропустить", headeText = "Анализы",
                        descriptionText = "Экспресс сбор и получение проб",
                        dotsImageBitmap = ImageBitmap.imageResource(R.drawable.group_1),
                        illustration = ImageBitmap.imageResource(R.drawable.illustration),
                        onClick = {navController.navigate("email")},
                        modifier = modifier
                    )
                }else if (page==1) {
                    OnBoard(
                        buttomText = "Пропустить", headeText = "Уведомления",
                        descriptionText = "Вы быстро узнаете о результатах",
                        dotsImageBitmap = ImageBitmap.imageResource(R.drawable.group_2),
                        illustration = ImageBitmap.imageResource(R.drawable.imagesscreen),
                        onClick = {navController.navigate("email")},
                        modifier = modifier)
                }else{
                    OnBoard(
                        buttomText = "Завершить", headeText = "Мониторинг",
                        descriptionText = "      Наши врачи всегда наблюдают \n" +
                                "за вашими показателями здоровья",
                        dotsImageBitmap = ImageBitmap.imageResource(R.drawable.group_3),
                        illustration = ImageBitmap.imageResource(R.drawable.images3),
                        onClick = {navController.navigate("email")},
                        modifier = modifier
                            .fillMaxSize())
                }
            }
        }

        composable("email") {
            Authorization(OnClick = {navController.navigate("emailCode")},
                onRegisterClick = {navController.navigate("authorizationTwo")}
            )
        }

        composable("authorizationTwo") {
            AuthorizationTwo (OnClick = {navController.navigate("emailCode2")},
                onRegisterClickTwo = {navController.navigate("email")})
        }

        composable("emailCode") {
            MainScreen()
        }

        composable("emailCode2") {
            CodeConfirmation(OnClick = {navController.navigate("email")},
                navController = navController)
        }

        composable("password") {
            CreatePassword(navController = navController)
        }

        composable("patientCard") {
            PatientCard(OnClick = {navController.navigate("mainScreen")},
                navController = navController)
        }

        composable("mainScreen") {
            MainScreen()
        }
    }
}

