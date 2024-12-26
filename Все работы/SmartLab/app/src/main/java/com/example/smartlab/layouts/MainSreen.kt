package com.example.smartlab.layouts

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartlab.allData.Actions
import com.example.smartlab.allData.Categories
import com.example.smartlab.allData.Products
import com.example.smartlab.components.CatalogText
import com.example.smartlab.retrofit.Retrofit
import com.example.smartlab.components.MainButton
import com.example.smartlab.components.StockDescText
import com.example.smartlab.components.StockTextMain
import com.example.smartlab.components.TextMain
import com.example.smartlab.ui.theme.BorderColor
import com.example.smartlab.ui.theme.textDescription
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Composable
fun MainScreen() {
    var id: Int = 0
    var name: String = ""
    var category_id: Int = 0
    var price: Float = 0.0F
    var text by remember { mutableStateOf("") }
    var showPromotions by remember { mutableStateOf(true) }
    var refreshing by remember { mutableStateOf(false) }
    val productsList = remember { mutableStateListOf<Products>() }
    val categoriesList = remember { mutableStateListOf<Categories>() }
    val actionsList = remember { mutableStateListOf<Actions>() }
    val pagerState = rememberPagerState(pageCount = { 3 })

    LaunchedEffect(Unit) {
        Retrofit.productInterface.getProsucts().enqueue(object : Callback<List<Products>> {
            override fun onResponse(
                call: Call<List<Products>>,
                response: Response<List<Products>>
            ) {
                response.body()?.let { products ->
                    productsList.clear()
                    productsList.addAll(products)
                }
            }

            override fun onFailure(p0: Call<List<Products>>, p1: Throwable) {
                Log.v("error", "error")
            }
        })
        Retrofit.categoryInterface.getCategory().enqueue(object : Callback<List<Categories>> {
            override fun onResponse(p0: Call<List<Categories>>, p1: Response<List<Categories>>) {
                p1.body()?.let { category ->
                    categoriesList.clear()
                    categoriesList.addAll(category)
                }
            }

            override fun onFailure(p0: Call<List<Categories>>, p1: Throwable) {
                Log.v("error", "error")
            }

        })
        Retrofit.actionsInterface.getActions().enqueue(object : Callback<List<Actions>> {
            override fun onResponse(p0: Call<List<Actions>>, p1: Response<List<Actions>>) {
                p1.body()?.let { actions ->
                    actionsList.clear()
                    actionsList.addAll(actions)
                }
            }

            override fun onFailure(p0: Call<List<Actions>>, p1: Throwable) {
                Log.v("error", "error")
            }
        })
    }
    Column(modifier = Modifier
        .padding(20.dp)
        .fillMaxSize()
        .pointerInput(Unit)
        {
            detectVerticalDragGestures { _, dragAmount ->
                if (dragAmount < 0) {
                    showPromotions = false
                } else if (dragAmount > 0 && !showPromotions) {
                    showPromotions = true
                }
            }
        }) {
        Spacer(modifier = Modifier.height(24.dp))
        TextMain(
            placeholder = "Искать анализы",
            enabled = true,
            onTextChange = { if (it.length <= 320) text = it },
            text = text,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Акции и новости",
            modifier = Modifier.padding(start = 8.dp),
            color = textDescription,
            fontSize = 17.sp,
            fontWeight = FontWeight.W600,
            lineHeight = 24.sp,

            )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {

            actionsList.forEach { actions ->
                Box(modifier = Modifier.padding(8.dp)) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .clip(shape = RoundedCornerShape(12.dp))
                            .background(
                                Color.Blue
                            )
                            .padding(16.dp)
                    ) {
                        StockTextMain(
                            text = actions.title
                        )
                        StockDescText(
                            text = actions.description
                        )
                        StockTextMain(
                            text = actions.price.toString()
                        )
                    }
                }
            }


        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Каталог анализов",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp),
            color = textDescription,
            fontSize = 17.sp,
            fontWeight = FontWeight.W600,
            lineHeight = 24.sp,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            categoriesList.forEach { category ->
                Box(modifier = Modifier.padding(8.dp)) {
                    MainButton(
                        onClick = {}, text = category.name,
                        Enable = true, modifier = Modifier.height(48.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            productsList.forEach { product ->
                var categor: String = ""
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .border(
                            width = 1.dp,
                            shape = RoundedCornerShape(12.dp),
                            color = BorderColor
                        )
                        .padding(16.dp)
                ) {
                    Column {
                        CatalogText(text = product.name)
                        Row {

                            Column(modifier = Modifier.weight(1f)) {
                                categoriesList.forEach { categories ->
                                    if (product.id == categories.id) {
                                        categor = categories.name.toString()
                                    }
                                }
                                Text(
                                    text = categor,
                                    modifier = Modifier.fillMaxWidth(),
                                    color = textDescription,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.W600,
                                    lineHeight = 20.sp,

                                    )
                                Text(
                                    text = product.price.toString(),
                                    modifier = Modifier.fillMaxWidth(),
                                    color = Color.Black,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.W600,
                                    lineHeight = 20.sp,

                                    )
                            }
                            MainButton(onClick = {
                                Log.v("433432", "ewqeqwe")

                            }, text = "Добавить", Enable = true, modifier = Modifier.height(48.dp))
                        }
                    }
                }
            }

        }

    }
}

@Preview
@Composable
private fun MainScreenView() {
    MainScreen()
}

