package com.bakharaalief.cleanarchitecturecompose.presentation

sealed class Screen(val destination : String){
    class HomeScreenDestination() : Screen("Home_Screen")
    class DetailScreenDestination() : Screen("Detail_Screen")
}
