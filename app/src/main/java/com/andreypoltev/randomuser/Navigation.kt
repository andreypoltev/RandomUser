package com.andreypoltev.randomuser

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andreypoltev.randomuser.util.Routes

@Composable
fun Navigation(viewModel: MainViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.mainScreen) {

        composable(Routes.mainScreen) {
            MainScreen(viewModel = viewModel, navController = navController)
        }

        composable(Routes.userDetailsScreen + "/{userId}") {
            UserDetailsScreen(
                viewModel = viewModel,
                navController = navController,
                id = it.arguments?.getString("userId")
            )
        }

    }

}