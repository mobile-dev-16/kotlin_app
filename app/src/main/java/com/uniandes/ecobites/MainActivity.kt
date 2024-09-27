package com.uniandes.ecobites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.uniandes.ecobites.ui.screens.CartScreen // Importamos la pantalla del carrito
import com.uniandes.ecobites.ui.theme.AppTheme
import com.uniandes.ecobites.ui.components.NavBar
import com.uniandes.ecobites.ui.navigation.NavigationHost
import com.uniandes.ecobites.ui.SplashScreen
import com.uniandes.ecobites.ui.screens.HomeScreen
import com.uniandes.ecobites.ui.screens.ProfileScreen
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    var showSplashScreen by remember { mutableStateOf(true) }

    // Mostrar pantalla de splash durante 3 segundos antes de navegar al contenido principal
    LaunchedEffect(Unit) {
        delay(3000) // 3 segundos
        showSplashScreen = false // Ocultar pantalla de splash después del retardo
    }

    if (showSplashScreen) {
        SplashScreen() // Mostrar pantalla de splash
    } else {
        // Mostrar la aplicación principal con navegación inferior
        var selectedTab by remember { mutableIntStateOf(0) }

        Scaffold(
            bottomBar = {
                NavBar(selectedTab = selectedTab, onTabSelected = { tab -> selectedTab = tab })
            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                // Según el tab seleccionado, mostramos la pantalla adecuada
                when (selectedTab) {
                    0 -> HomeScreen()  // Aquí podrías colocar la pantalla de inicio
                    1 -> CartScreen()  // Pantalla del carrito de compras
                    2 -> ProfileScreen()  // Aquí podrías colocar la pantalla de perfil
                }
            }
        }
    }
}

