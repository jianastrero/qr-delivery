package com.jianastrero.templateandroidapp.navgraph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jianastrero.templateandroidapp.enumeration.Screen
import com.jianastrero.templateandroidapp.extension.navigate
import com.jianastrero.templateandroidapp.model.detail.DetailArguments
import com.jianastrero.templateandroidapp.screen.DetailScreen
import com.jianastrero.templateandroidapp.screen.HomeScreen

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
