package com.example.semana4.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun Cronometro(){
    var tiempo by remember { mutableStateOf(0) }
    var ejecutar by remember { mutableStateOf(false) }
}