package com.example.rockpaperscissor.model

fun getResult(player: Choice, computer: Choice): String {
    if (player == computer) return "DRAW"

    return when (player) {
        Choice.ROCK -> if (computer == Choice.SCISSORS) "WIN" else "LOSE"
        Choice.PAPER -> if (computer == Choice.ROCK) "WIN" else "LOSE"
        Choice.SCISSORS -> if (computer == Choice.PAPER) "WIN" else "LOSE"
    }
}