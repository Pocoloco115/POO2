package com.example.task.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.task.ui.screen.DetailScreen
import com.example.task.ui.screen.HomeScreen

@Composable
fun AppNavigation(modifier: Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Home){
        composable<Home>{
            HomeScreen(
                onGoToDetail = { id ->
                    navController.navigate(Detail(id))
                }
            )
        }
        composable<Detail>{ backStackEntry ->
            val args = backStackEntry.toRoute<Detail>()
            DetailScreen(
                userId = args.usuarioId,
                onBack = { navController.popBackStack() }
            )

        }
    }
}