package com.uniandes.ecobites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.uniandes.ecobites.ui.components.NavBar
import com.uniandes.ecobites.ui.navigation.NavigationHost
import com.uniandes.ecobites.ui.theme.EcoBitesTheme
import com.uniandes.ecobites.ui.SplashScreen
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcoBitesTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    var showSplashScreen by remember { mutableStateOf(true) }

    // Show splash screen for 3 seconds (3000 ms) before navigating to main content
    LaunchedEffect(Unit) {
        delay(3000) // 3 seconds
        showSplashScreen = false // Hide splash screen after delay
    }

    if (showSplashScreen) {
        SplashScreen() // Show splash screen
    } else {
        // Show main app with bottom navigation after splash screen disappears
        var selectedTab by remember { mutableIntStateOf(0) }

        Scaffold(
            bottomBar = {
                NavBar(selectedTab = selectedTab, onTabSelected = { tab -> selectedTab = tab })
            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                NavigationHost(selectedTab = selectedTab)
            }
        }
    }
}
