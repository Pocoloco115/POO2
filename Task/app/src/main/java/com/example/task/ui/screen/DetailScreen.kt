package com.example.task.ui.screen

import android.widget.TextClock
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.task.ui.navigation.Detail

@Composable
fun DetailScreen(
    userId: Int,
    onBack: () -> Unit
){
    Column(){
        Text(text = "Detail Screen ${userId}")
        Button(onClick = { onBack() }) {
            Text(text = "Go back")
        }
    }
}