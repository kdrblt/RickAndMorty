package com.example.rickandmorty.ui.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.rickandmorty.R
import com.example.rickandmorty.ui.theme.Black
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToCharacters: () -> Unit,
) {
    val scale = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                },
            ),
        )
        delay(3000L)
        navigateToCharacters.invoke()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black),
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.ic_rick_sanchez,
            ),
            contentDescription = null,
            modifier = Modifier.align(Alignment.Center),
        )
    }
}
