package dev.jianastrero.qr_delivery.navgraph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.jianastrero.qr_delivery.enumeration.Screen
import dev.jianastrero.qr_delivery.extension.navigate
import dev.jianastrero.qr_delivery.model.detail.DetailArguments
import dev.jianastrero.qr_delivery.screen.DetailScreen
import dev.jianastrero.qr_delivery.screen.HomeScreen

@Composable
fun MainNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onNextClick = { message, value ->
                    navController.navigate(
                        Screen.Detail,
                        arguments = mapOf(
                            Screen.Detail.TITLE to message,
                            Screen.Detail.VALUE to value
                        )
                    )
                },
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        composable(Screen.Detail.route, Screen.Detail.namedNavArguments) {
            val detailArguments = Screen.Detail.getValues<DetailArguments>(it, DetailArguments())
            DetailScreen(
                detailArguments = detailArguments,
                onBackClick = { navController.popBackStack() },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
