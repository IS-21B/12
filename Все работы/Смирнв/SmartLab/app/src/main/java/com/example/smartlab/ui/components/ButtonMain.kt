package com.example.smartlab.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.smartlab.ui.theme.AccentColor

@Composable
fun ButtonMain(modifier: Modifier = Modifier, onClick: () -> Unit, text: String, enabled: Boolean, colorContainer: Color, colorContent: Color) {
    Button(
        modifier = modifier,
        onClick = { onClick() },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorContainer,
            contentColor = colorContent,
            disabledContentColor = Color.White,
            disabledContainerColor = Color(0xffC9D4FB)
            ),
        border = BorderStroke(1.dp, Color(0xFFCCCCCC)),
        enabled = enabled
    ) {
        Text(
            text = text,
            fontSize = 17.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 24.sp
        )
    }
}
@Preview
@Composable
private fun ButtonMainPrev() {
    ButtonMain(modifier = Modifier.fillMaxWidth(), onClick = {}, text = "Далее", enabled = true, AccentColor, Color.White)
}