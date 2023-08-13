package com.example.rickandmorty.navigation

sealed class Screens(val route: String) {
    object SplashScreen : Screens("splash_screen")
    object CharactersScreen : Screens("characters_screen")
    object CharacterDetailScreen : Screens("character_detail_screen")
}
