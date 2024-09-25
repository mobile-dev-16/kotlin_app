package com.uniandes.ecobites

import HomeScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.uniandes.ecobites.ui.theme.AppTheme
import com.uniandes.ecobites.ui.components.NavBar
import com.uniandes.ecobites.ui.navigation.NavigationHost
import com.uniandes.ecobites.ui.SplashScreen
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

    LaunchedEffect(Unit) {
        delay(3000)
        showSplashScreen = false
    }

    if (showSplashScreen) {
        SplashScreen()
    } else {
        MainContent()
    }
}

@Composable
fun MainContent() {
    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            NavBar(selectedTab = selectedTab, onTabSelected = { tab -> selectedTab = tab })
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedTab) {
                0 -> HomeScreen()
                else -> NavigationHost(selectedTab = selectedTab)
            }
        }
    }
}
