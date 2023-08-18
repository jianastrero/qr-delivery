package dev.jianastrero.qr_delivery.navgraph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dev.jianastrero.qr_delivery.enumeration.Screen
import dev.jianastrero.qr_delivery.extension.composable
import dev.jianastrero.qr_delivery.extension.navigate
import dev.jianastrero.qr_delivery.screen.AuthScreen
import dev.jianastrero.qr_delivery.screen.MainScreen

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Auth.route,
        modifier = modifier
    ) {
        composable(Screen.Auth) {
            AuthScreen(
                onLoginClicked = {
                    navController.navigate(Screen.Main) {
                        popUpTo(Screen.Auth.route) {
                            inclusive = true
                        }
                    }
                },
                modifier = Modifier.fillMaxSize()
            )
        }
        composable(Screen.Main) {
            MainScreen(modifier = Modifier.fillMaxSize())
        }
    }
}
