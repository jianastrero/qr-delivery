package dev.jianastrero.qr_delivery.navgraph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dev.jianastrero.qr_delivery.enumeration.Screen
import dev.jianastrero.qr_delivery.extension.composable

@Composable
fun MainNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Auth.route,
        modifier = modifier
    ) {
        composable(Screen.BottomNav.Home) {
            TODO("Home Screen")
        }
        composable(Screen.BottomNav.Parcels) {
            TODO("Parcels Screen")
        }
        composable(Screen.BottomNav.Wallet) {
            TODO("Parcels Screen")
        }
        composable(Screen.BottomNav.Profile) {
            TODO("Parcels Screen")
        }
    }
}
