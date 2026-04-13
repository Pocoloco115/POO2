package com.example.formulariodesing.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.formulariodesing.ui.theme.BluePrimary
import com.example.formulariodesing.ui.theme.BlueSecondary

@Composable
fun LoginScreen(onLogin: () -> Unit) {
    val scope = rememberCoroutineScope()
    val mail by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().
        background(
            brush = Brush.verticalGradient(
                colors = listOf(BluePrimary, BlueSecondary)
            )
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(80.dp))
        Box(
            modifier = Modifier.size(100.dp).
            clip(CircleShape).
            background(White),
            contentAlignment = Alignment.Center
        ){
            Text("UAM", fontSize = 40.sp, fontWeight = FontWeight.Bold, color = BluePrimary)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Universidad Americana", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = White)
        Spacer(modifier = Modifier.height(40.dp))
        Card(
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(modifier = Modifier.padding(24.dp)) {

                OutlinedTextField(
                    Value = mail,
                    onValueChange = { mail = it },
                    label = { Text("Correo electrónico") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    Value = password,
                    onValueChange = { password = it },
                    label = { Text("Contraseña") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                trailingIcon = {
                    val text = if(showPassword) "Ocultar" else "Mostrar"
                    Text(text = text,
                        modifier = Modifier.clickable { showPassword = !showPassword } .padding(end = 8.dp),
                        color = BluePrimary,
                        fontSize = 12.sp)

                    )
                }
            }

        }
    }
}