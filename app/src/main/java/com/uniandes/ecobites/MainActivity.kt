package com.uniandes.ecobites
import kotlinx.coroutines.delay
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uniandes.ecobites.ui.SplashScreen
import com.uniandes.ecobites.ui.components.NavBar
import com.uniandes.ecobites.ui.navigation.NavigationHost
import com.uniandes.ecobites.ui.screens.*
import com.uniandes.ecobites.ui.theme.AppTheme
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
    val navController = rememberNavController()
    var showSplashScreen by remember { mutableStateOf(true) }

    // Show splash screen for 3 seconds before navigating to main content
    LaunchedEffect(Unit) {
        delay(3000) // 3 seconds
        showSplashScreen = false // Hide splash screen after delay
    }

    if (showSplashScreen) {
        SplashScreen() // Display splash screen
    } else {
        // Set up navigation using NavHost
        NavHost(
            navController = navController,
            startDestination = "login"
        ) {
            composable("login") {
                LoginScreen(
                    onSignInClicked = { navController.navigate("mainContent") },
                    onSignUpClicked = { navController.navigate("register") }
                )
            }
            composable("mainContent") { MainContent(navController) }
            composable("register") { RegisterScreen(navController, onSignUpClicked = {}) }
        }
    }
}

@Composable
fun MainContent(navController: NavHostController) {
    var selectedTab by remember { mutableStateOf(0) }

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

@Composable
fun LoginScreen(onSignInClicked: () -> Unit, onSignUpClicked: () -> Unit) {
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

        // Button for Sign In
        Button(
            onClick = onSignInClicked,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sign in")
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Button for Sign Up
        Button(
            onClick = onSignUpClicked,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sign Up")
        }
    }
}
