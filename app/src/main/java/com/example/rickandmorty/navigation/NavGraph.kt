package com.example.rickandmorty.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rickandmorty.ui.characterdetail.CharacterDetailScreen
import com.example.rickandmorty.ui.characters.CharactersScreen
import com.example.rickandmorty.ui.splash.SplashScreen

@Composable
fun NavGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreen.route,
        modifier = Modifier.padding(paddingValues = paddingValues),
    ) {
        composable(route = Screens.SplashScreen.route) {
            SplashScreen(
                navigateToCharacters = {
                    navController.navigate(
                        Screens.CharactersScreen.route,
                    )
                },
            )
        }
        composable(route = Screens.CharactersScreen.route) {
            CharactersScreen(
                navigateToDetail = {
                    navController.navigate(
                        "${Screens.CharacterDetailScreen.route}/$it",
                    )
                },
            )
        }

        composable(route = "${Screens.CharacterDetailScreen.route}/{characterId}") {
            CharacterDetailScreen()
        }
    }
}
