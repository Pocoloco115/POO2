package com.example.rockpaperscissor.ui
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.rockpaperscissor.R
import com.example.rockpaperscissor.model.Choice
import com.example.rockpaperscissor.model.getResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RockPaperScissorsScreen() {
    var playerChoice by remember { mutableStateOf<Choice?>(null) }
    var computerChoice by remember { mutableStateOf<Choice?>(null) }

    var playerWins by remember { mutableStateOf(0) }
    var computerWins by remember { mutableStateOf(0) }
    var rounds by remember { mutableStateOf(0) }
    var drawCount by remember { mutableStateOf(0) }
    var isPlaying by remember { mutableStateOf(false) }
    var countdownIndex by remember { mutableStateOf(-1) }
    var result by remember { mutableStateOf<String?>(null) }

    val countdownFrames = listOf(
        R.drawable.count_3,
        R.drawable.count_2,
        R.drawable.count_1
    )

    val scope = rememberCoroutineScope()

    fun startRound() {
        if (playerChoice == null || isPlaying) return
        result = null
        isPlaying = true
        countdownIndex = 0

        scope.launch {
            for (i in countdownFrames.indices) {
                countdownIndex = i
                delay(500)
            }
            countdownIndex = -1

            val compChoice = Choice.values().random()
            computerChoice = compChoice

            val r = getResult(playerChoice!!, compChoice)
            result = r
            rounds++
            when (result) {
                "WIN" -> {
                    playerWins++
                }
                "LOSE" -> {
                    computerWins++
                }
                "DRAW" -> {
                    drawCount++
                }
            }

            playerChoice = null
            isPlaying = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Cuarzo, Papiro o Navaja",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(16.dp))

        Text(text = "Tu elección", style = MaterialTheme.typography.titleMedium)

        Spacer(Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ChoiceItem(
                selected = playerChoice == Choice.ROCK,
                imageRes = R.drawable.rock,
                label = "Cuarzo",
                onClick = { if (!isPlaying) playerChoice = Choice.ROCK }
            )
            ChoiceItem(
                selected = playerChoice == Choice.PAPER,
                imageRes = R.drawable.paper,
                label = "Papiro",
                onClick = { if (!isPlaying) playerChoice = Choice.PAPER }
            )
            ChoiceItem(
                selected = playerChoice == Choice.SCISSORS,
                imageRes = R.drawable.scissor,
                label = "Navaja",
                onClick = { if (!isPlaying) playerChoice = Choice.SCISSORS }
            )
        }

        Spacer(Modifier.height(24.dp))

        if (countdownIndex >= 0) {
            Image(
                painter = painterResource(id = countdownFrames[countdownIndex]),
                contentDescription = "Cuenta regresiva",
                modifier = Modifier.size(80.dp)
            )
        }

        Spacer(Modifier.height(16.dp))

        Text(text = "Botsito", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(8.dp))

        if (computerChoice != null) {
            val resId = when (computerChoice!!) {
                Choice.ROCK -> R.drawable.rock
                Choice.PAPER -> R.drawable.paper
                Choice.SCISSORS -> R.drawable.scissor

            }
            Image(
                painter = painterResource(id = resId),
                contentDescription = "Elección máquina",
                modifier = Modifier.size(80.dp)
            )
        } else {
            Text("Aún no ha jugado")
        }
        if(result != null){
            Spacer(Modifier.height(16.dp))
            Text(
                text = if (result == "WIN") "Ganaste" else if (result == "LOSE") "Botsito ganó" else "Empate",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = if (result == "WIN") Color.Cyan else if (result == "LOSE") Color.Red else Color.Gray
            )
        }


        Spacer(Modifier.height(24.dp))
        Text(
            text = "Partidas jugadas",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = "$rounds",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "Jugador - Victorias: $playerWins",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "Botsito - Victorias: $computerWins",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "Empates: $drawCount",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = { startRound() },
            enabled = !isPlaying && playerChoice != null
        ) {
            Text("Play")
        }
    }
}

@Composable
fun ChoiceItem(
    selected: Boolean,
    imageRes: Int,
    label: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clickable { onClick() }
            .border(
                width = if (selected) 3.dp else 0.dp,
                color = if (selected) Color.Cyan else Color.Transparent,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = label,
            modifier = Modifier.size(80.dp)
        )
        Text(text = label)
    }
}