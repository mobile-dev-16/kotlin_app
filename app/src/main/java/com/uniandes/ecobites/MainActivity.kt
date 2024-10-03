package com.uniandes.ecobites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uniandes.ecobites.ui.screens.CartScreen
import com.uniandes.ecobites.ui.screens.home.HomeScreen
import com.uniandes.ecobites.ui.screens.ProfileScreen
import com.uniandes.ecobites.ui.theme.AppTheme
import com.uniandes.ecobites.ui.components.NavBar
import com.uniandes.ecobites.ui.SplashScreen
import com.uniandes.ecobites.ui.screens.LoginScreen
import io.github.jan.supabase.createSupabaseClient
import kotlinx.coroutines.delay
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.postgrest.Postgrest

val supabase = createSupabaseClient(
    supabaseUrl = "https://nlhcaanwwchxdzdiyizf.supabase.co",
    supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im5saGNhYW53d2NoeGR6ZGl5aXpmIiwicm9sZSI6ImFub24iLCJpYXQiOjE3Mjc5MDc0OTQsImV4cCI6MjA0MzQ4MzQ5NH0.LrcRGkVH1qjPE09xDngX7wrtrUmfIYbTGrgbPKarTeM"
) {
    install(Auth)
    install(Postgrest)
    //install other modules
}

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
    var isLoggedIn by remember { mutableStateOf(false) } // Track login state

    // Show splash screen for 3 seconds before navigating to the main content
    LaunchedEffect(Unit) {
        delay(3000) // 3 seconds delay
        showSplashScreen = false // Hide splash screen after the delay
    }

    if (showSplashScreen) {
        SplashScreen() // Show splash screen
    } else if (!isLoggedIn) {
        LoginScreen(onLoginSuccess = { isLoggedIn = true }) // Pass a callback to update isLoggedIn
    } else {
        MainContent() // Show main content if logged in
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
                1 -> CartScreen()
                2 -> ProfileScreen()
            }
        }
    }
}

