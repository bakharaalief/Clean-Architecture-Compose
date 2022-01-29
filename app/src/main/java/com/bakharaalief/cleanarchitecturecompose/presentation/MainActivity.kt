package com.bakharaalief.cleanarchitecturecompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bakharaalief.cleanarchitecturecompose.presentation.ui.theme.BelajarDaggerComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //view model
        val viewModel = ViewModelProvider(this)[PostVM::class.java]

        setContent {
            BelajarDaggerComposeTheme {
                Navigation(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun Navigation(viewModel : PostVM){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreenDestination().destination
    ){

        //home screen
        composable(Screen.HomeScreenDestination().destination){
            MainScreen(postVM = viewModel, navController = navController)
        }

        //home screen
        composable(Screen.DetailScreenDestination().destination){
            DetailScreen()
        }
    }
}


