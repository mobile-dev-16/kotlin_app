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
import com.example.ecobites.LoginScreen
import com.uniandes.ecobites.ui.screens.CartScreen
import com.uniandes.ecobites.ui.screens.HomeScreen
import com.uniandes.ecobites.ui.screens.ProfileScreen
import com.uniandes.ecobites.ui.theme.AppTheme
import com.uniandes.ecobites.ui.components.NavBar
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
    var isLoggedIn by remember { mutableStateOf(false) }

    // Mostrar pantalla de splash durante 3 segundos antes de navegar al contenido principal
    LaunchedEffect(Unit) {
        delay(3000) // 3 segundos
        showSplashScreen = false // Ocultar pantalla de splash después del retardo
    }

    if (showSplashScreen) {
        SplashScreen() // Mostrar pantalla de splash
    } else if (!isLoggedIn) {
        LoginScreen(onSignInClicked = { isLoggedIn = true })
    } else {
        MainContent()
    }
}

@Composable
fun MainContent() {
    var selectedTab by remember { mutableStateOf(0) }

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

@Composable
fun LoginScreen(onSignInClicked: () -> Unit) {
    Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Text(text = "Log in", fontSize = 24.sp)
    Spacer(modifier = Modifier.height(24.dp))

    Text(text = "eco", fontSize = 48.sp, color = androidx.compose.ui.graphics.Color(0xFF4A6A2B))
    Text(text = "bites", fontSize = 48.sp, color = androidx.compose.ui.graphics.Color(0xFF4A6A2B))

    Spacer(modifier = Modifier.height(24.dp))

    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = { Text("Username") },
        modifier = Modifier.fillMaxWidth()
    )

    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = { Text("Password") },
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = PasswordVisualTransformation()
    )

    Spacer(modifier = Modifier.height(16.dp))

    Button(
        onClick = {onSignInClicked() },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Sign in")
    }

    Spacer(modifier = Modifier.height(10.dp))

    Button(
        onClick = { /* Implement sign-up logic */ },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Sign Up")
    }
}
}
