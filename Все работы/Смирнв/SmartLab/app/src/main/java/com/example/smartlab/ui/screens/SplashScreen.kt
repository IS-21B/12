package com.example.smartlab.ui.screens
//класс анимирования и переключения на первый макет
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.smartlab.R
import kotlinx.coroutines.delay
import com.example.smartlab.ui.theme.BlueBackGround

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(4f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(1f).getInterpolation(it)
                })
        )
        delay(2000L)
        navController.navigate("welcome_pager")
    }

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize().background(BlueBackGround)
    ) {
        Image(bitmap = ImageBitmap.imageResource(R.drawable.bg), contentDescription = "", modifier = Modifier.fillMaxSize())
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(260.dp, 47.dp).scale(scale.value))
    }
}