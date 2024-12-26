package com.example.karginsmartt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.karginsmartt.Navigation.AddNavigation
import com.example.karginsmartt.ui.theme.KarginSmarttTheme
import com.example.karginsmartt.ui.theme.scrins.EmailSocdati
import com.example.karginsmartt.ui.theme.scrins.OnAvto
import com.example.karginsmartt.ui.theme.scrins.OnBoard
import com.example.karginsmartt.ui.theme.scrins.Patient

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val pagerState = rememberPagerState(pageCount = {
                1
            })
            KarginSmarttTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HorizontalPager(state = pagerState) {page->
                        AddNavigation(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}
