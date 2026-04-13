package com.example.task.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(onGoToDetail: (Int) -> Unit){
    Column() {
        Text(text = "Home Screen")
        Button(onClick = { onGoToDetail(1) }) {
            Text(text = "Go to Detail")
        }

    }
}
