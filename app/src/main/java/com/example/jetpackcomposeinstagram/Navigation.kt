package com.example.jetpackcomposeinstagram

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.jetpackcomposeinstagram.model.Routes

@Composable
fun Screen1(navigationsController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text(
            text = "Pantalla1",
            Modifier
                .align(Alignment.Center)
                .clickable { navigationsController.navigate(Routes.Pantalla2.routes) })
    }
}

@Composable
fun Screen2(navigationsController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text(text = "Pantalla2",
            Modifier
                .align(Alignment.Center)
                .clickable {
                    navigationsController.navigate(
                        Routes.Pantalla3.routes
                    )
                })
    }
}

@Composable
fun Screen3(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        Text(text = "Pantalla3", Modifier.align(Alignment.Center).clickable { navController.navigate(Routes.Pantalla4.createRoute(20)) })
    }
}


@Composable
fun Screen4(navController: NavHostController, age: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        Text(text = "Tengo $age años", Modifier.align(Alignment.Center).clickable { navController.navigate(Routes.Pantalla5.createRoute("feña")) })
    }
}
@Composable
fun Screen5(navigationsController: NavHostController, name:String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        Text(text = "Me llamo $name", Modifier.align(Alignment.Center))
    }
}