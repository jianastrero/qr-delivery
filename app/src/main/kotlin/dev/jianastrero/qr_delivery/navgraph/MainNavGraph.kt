package dev.jianastrero.qr_delivery.navgraph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dev.jianastrero.qr_delivery.enumeration.Screen
import dev.jianastrero.qr_delivery.extension.composable
import dev.jianastrero.qr_delivery.page.HomePage
import dev.jianastrero.qr_delivery.page.ParcelPage
import dev.jianastrero.qr_delivery.page.ProfilePage
import dev.jianastrero.qr_delivery.page.TrackPage
import dev.jianastrero.qr_delivery.page.WalletPage

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
            HomePage(modifier = Modifier.fillMaxSize())
        }
        composable(Screen.BottomNav.Parcels) {
            ParcelPage(modifier = Modifier.fillMaxSize())
        }
        composable(Screen.BottomNav.Track) {
            TrackPage(modifier = Modifier.fillMaxSize())
        }
        composable(Screen.BottomNav.Wallet) {
            WalletPage(modifier = Modifier.fillMaxSize())
        }
        composable(Screen.BottomNav.Profile) {
            ProfilePage(modifier = Modifier.fillMaxSize())
        }
    }
}
