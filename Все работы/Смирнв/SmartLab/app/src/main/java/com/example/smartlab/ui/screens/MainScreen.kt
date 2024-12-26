package com.example.smartlab.ui.screens

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartlab.Action
import com.example.smartlab.R
import com.example.smartlab.RetrofitHelper
import com.example.smartlab.RetrofitInterface
import com.example.smartlab.ui.theme.AccentColor
import com.example.smartlab.ui.theme.FocusedBorderColor
import com.example.smartlab.ui.theme.FocusedContainerColor
import com.example.smartlab.ui.theme.FocusedPlaceholderColor
import com.example.smartlab.ui.theme.UnfocusedBorderColor
import com.example.smartlab.ui.theme.UnfocusedContainerColor
import com.example.smartlab.ui.theme.UnfocusedPlaceholderColor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun isNetworkAvailable(): Boolean {
    val context = LocalContext.current
    val connectivityManager = remember {
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }
    val networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
    return networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
}

fun randomColour(): List<Color> {
    val colors_themes = listOf(
        listOf(
            Color(0xFF76B2FF),
            Color(0xFFB4D5FF)
        ),
        listOf(
            Color(0xFF388E3C),
            Color(0xFFC8E6C9)
        ),
        listOf(
            Color(0xFFD32F2F),
            Color(0xFFF44336).copy(alpha=0.5f)
        ),
        listOf(
            Color(0xFF6A1B9A),
            Color(0xFFE1BEE7)
        ),
        listOf(
            Color(0xFFF57C00),
            Color(0xFFFFE0B2)
        ),
        listOf(
            Color(0xFFFFC107),
            Color(0xFFFFF9C4)
        ),
        listOf(
            Color(0xFFE91E63),
            Color(0xFFF8BBD0)
        ),
        listOf(
            Color(0xFF00ACC1),
            Color(0xFFB2EBF2)
        ),
        listOf(
            Color(0xFF424242),
            Color(0xFFE0E0E0)
        ),
        listOf(
            Color(0xFF795548),
            Color(0xFFD7CCC8)
        )
    )
    val random_index = (0..9).random()
    return colors_themes[random_index]
}
fun getActions(context: Context): Array<Action>? {
    var result: Array<Action>?
    result = arrayOf(
        Action(
            id = 1,
            title = "TODO()",
            description = "TODO()",
            price = 8f,
            image = "TODO()",
        )
    )

    val api_key = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InR4cnh1a3FqcnNjY3BqYXRrbm1uIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzUxMTA1OTEsImV4cCI6MjA1MDY4NjU5MX0.eBjZhz8vBtcX-rVLJBQciTPCJAhdkG8eQwDHFKZ4Oow"
    val password_db = "database_my"
    val api = RetrofitHelper.getClient(
        supabaseAnonKey = api_key,
        supabaseJwtToken = password_db
    ).create(RetrofitInterface::class.java)
    val actionsCall = api.getActions(
        apiKey = api_key,
        authHeader = "Bearer ${password_db}"
    )
    actionsCall.enqueue(object : Callback<Array<Action>>{
        override fun onResponse(call: Call<Array<Action>>, response: Response<Array<Action>>) {
            if(response.isSuccessful) {
                result = response.body()
            }
        }

        override fun onFailure(call: Call<Array<Action>>, t: Throwable) {
            val toast = Toast.makeText(context, "Произошла ошибка при вызове акций: ${t.message}", Toast.LENGTH_LONG)
            toast.show()
            Log.e("DATABASE", "Произошла ошибка при вызове акций: ${t.message}")
        }
    })
    return result
}
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val available_internet = isNetworkAvailable()
    Log.e("INTERNET", "Доступ в интернет: ${available_internet}")
    val arrayActions: Array<Action>? = getActions(LocalContext.current)
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 24.dp, start = 20.dp, end = 20.dp)) {
        SearchField(placeholder = "Искать анализы")
        Spacer(Modifier.height(32.dp))
        HeadersGray(text = "Акции и новости")
        Spacer(Modifier.height(16.dp))
        Row(Modifier
            .fillMaxWidth()
            .horizontalScroll(ScrollState(0))) {
            arrayActions?.forEach { action ->
                NewsBlock(
                    header = action.title,
                    desc = action.description,
                    cost = "${action.price} ₽"
                )
                Spacer(Modifier.width(16.dp))
            }
        }

    }
}

@Composable
fun NewsBlock(modifier: Modifier = Modifier, header: String, desc: String, cost: String) {
    Column(
        modifier = Modifier
            .width(270.dp)
            .height(152.dp)
            .clip(shape = RoundedCornerShape(12.dp))
            .background(
                brush = Brush.horizontalGradient(
                    colors = randomColour()
                )
            )
    ) {
        HeaderBlock(text = header)
        Spacer(Modifier.weight(1f))
        DescriptionBlock(text = desc)
        CostBlock(text = cost)
    }
}
@Composable
fun HeaderBlock(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight(800),
        lineHeight = 28.sp,
        color = Color.White,
        modifier = Modifier.padding(16.dp)
    )
}
@Composable
fun DescriptionBlock(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text,
        fontSize = 14.sp,
        fontWeight = FontWeight(400),
        lineHeight = 20.sp,
        color = Color.White,
        modifier = Modifier.padding(start = 16.dp)
    )
}
@Composable
fun CostBlock(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight(800),
        lineHeight = 28.sp,
        color = Color.White,
        modifier = Modifier.padding(start = 16.dp, bottom = 12.dp)
    )
}
@Composable
fun SearchField(modifier: Modifier = Modifier, placeholder: String) {

    // TextFiled for search
    var text by remember { mutableStateOf("") }
    TextField(
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.icons),
                modifier = Modifier.size(20.dp),
                contentDescription = ""
            )
        },
        value = text,
        onValueChange = { text = it},
        placeholder = {
            Text(
                text = placeholder,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 20.sp
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = FocusedContainerColor,
            unfocusedContainerColor = UnfocusedContainerColor,
            focusedPlaceholderColor = FocusedPlaceholderColor,
            unfocusedPlaceholderColor = UnfocusedPlaceholderColor,
            focusedBorderColor = FocusedBorderColor,
            unfocusedBorderColor = UnfocusedBorderColor,
            cursorColor = AccentColor
        ),
        shape = RoundedCornerShape(10.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )
}

@Composable
fun HeadersGray(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text,
        fontWeight = FontWeight(600),
        fontSize = 17.sp,
        lineHeight = 24.sp,
        color = Color(0xFF939396)
    )
}
@Preview
@Composable
private fun MainScreenPrev() {
    MainScreen()
}