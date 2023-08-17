package dev.jianastrero.qr_delivery.navgraph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.jianastrero.qr_delivery.enumeration.Screen
import dev.jianastrero.qr_delivery.screen.AuthScreen
import dev.jianastrero.qr_delivery.screen.HomeScreen

@Composable
fun MainNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Auth.route
    ) {
        composable(Screen.Auth.route) {
            AuthScreen(modifier = Modifier.fillMaxSize())
        }
        composable(Screen.Home.route) {
            HomeScreen(
                onNextClick = { _, _ ->
                },
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}
