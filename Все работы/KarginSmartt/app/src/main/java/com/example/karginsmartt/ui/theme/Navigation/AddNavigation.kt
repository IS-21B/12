package com.example.karginsmartt.Navigation

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
import com.example.karginsmartt.ui.theme.scrins.OnBoard
import com.example.karginsmartt.R
import com.example.karginsmartt.ui.theme.scrins.EmailSocdati
import com.example.karginsmartt.ui.theme.scrins.OnAvto
import com.example.karginsmartt.ui.theme.scrins.OnAvtoTwo
import com.example.karginsmartt.ui.theme.scrins.Password
import com.example.karginsmartt.ui.theme.scrins.Patient


//Описание назначения класса - AppNavigation управляет навигацией в приложении.
// Он определяет, какие экраны отображаются и как пользователь переходит между ними
//Дата создания - 23.12.2024;
//Автор создания - Каргин;
@Composable
fun AddNavigation(modifier: Modifier = Modifier) {
    val navControler = rememberNavController()
// NavHost - контейнер для навигационных графов
    NavHost(navControler, startDestination = "Day-1") {
        composable("Day-1") {
            val pagerState =
                rememberPagerState(pageCount = {   // Состояние для управления HorizontalPager
                    3
                })
            HorizontalPager(state = pagerState) { page ->
                // Отображение разных экранов OnBoard в зависимости от текущей страницы
                if (page == 0) {

                    OnBoard(
                        buttomText = "Пропустить", headeText = "Анализы",
                        descriptionText = "Экспресс сбор и получение проб",
                        dotsImageBitmap = ImageBitmap.imageResource(R.drawable.group1_2),
                        illustration = ImageBitmap.imageResource(R.drawable.group1_3),
                        onClick = { navControler.navigate("email") },
                        modifier = modifier
                    )
                } else if (page == 1) {

                    OnBoard(
                        buttomText = "Пропустить", headeText = "Уведомления",
                        descriptionText = "Вы быстро узнаете о результатах",
                        dotsImageBitmap = ImageBitmap.imageResource(R.drawable.group_2_2),
                        illustration = ImageBitmap.imageResource(R.drawable.group2_3),
                        onClick = { navControler.navigate("email") },
                        modifier = modifier
                    )
                } else {

                    OnBoard(
                        buttomText = "Завершить", headeText = "Мониторинг",
                        descriptionText = "Наши врачи всегда наблюдают \n" +
                                "за вашими показателями здоровья",
                        dotsImageBitmap = ImageBitmap.imageResource(R.drawable.group_3_2),
                        illustration = ImageBitmap.imageResource(R.drawable.group3_3),
                        onClick = { navControler.navigate("email") },
                        modifier = modifier
                            .fillMaxSize()
                    )
                }
            }
        }
        composable("email") {
            OnAvto(
                onClick = { navControler.navigate("emailcode") },
                onRegisterClick = {navControler.navigate("register")},
            )
        }
        composable("register") {
            OnAvtoTwo(
                onClick = { navControler.navigate("register") },
                onRegisterClickTwo = {navControler.navigate("email")},
                onNavigateBack = {navControler.navigate("EmailSocdati/{randomCode}")}
            )
        }
        composable("EmailSocdati/{randomCode}") { backStackEntry ->
            EmailSocdati(
                navController = navControler,
                onNavigateBack = { navControler.popBackStack() }
            )
        }

        composable("creaturepassword") {
            Password(
                onSkip = { navControler.navigate("createpatientcardscreen") },
                onCreate = { navControler.navigate("createpatientcardscreen") }
            )
        }
        composable("createpatientcardscreen") {
            Patient(
                onSkip = { navControler.navigate("home") },
                onCreate = { navControler.navigate("home") }
            )
        }
    }
}



