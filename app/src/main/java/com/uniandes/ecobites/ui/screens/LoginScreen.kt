package com.uniandes.ecobites.ui.screens

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.uniandes.ecobites.R
import io.github.jan.supabase.createSupabaseClient
import kotlinx.coroutines.launch
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email

// Initialize Supabase
val supabase = createSupabaseClient(
    supabaseUrl = "https://nlhcaanwwchxdzdiyizf.supabase.co",  // Replace with your actual Supabase URL
    supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im5saGNhYW53d2NoeGR6ZGl5aXpmIiwicm9sZSI6ImFub24iLCJpYXQiOjE3Mjc5MDc0OTQsImV4cCI6MjA0MzQ4MzQ5NH0.LrcRGkVH1qjPE09xDngX7wrtrUmfIYbTGrgbPKarTeM"                  // Replace with your actual Supabase anon key
){
    install(Auth)
}
val auth = supabase.auth

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope() // For launching coroutines

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surfaceContainer)
    ) {
        // Log in text at the top
        Text(
            text = "Log in",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.TopCenter) // Align to the top center
                .padding(top = 28.dp) // Add padding from the top
        )

        // Content in the center
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon),
                contentDescription = "Eco Bites Logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(350.dp)
                    .height(350.dp)
            )

//            Spacer(modifier = Modifier.height(16.dp))

            // Email Input Field
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Password Input Field
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Sign-In Button
            Button(
                onClick = {
                    coroutineScope.launch {
                        try {
                            auth.signInWith(Email) {
                                this.email = email
                                this.password = password
                            }
                            Toast.makeText(context, "Signed in successfully!", Toast.LENGTH_LONG).show()
                            onLoginSuccess() // Call the callback to update the login state
                        } catch (e: Exception) {
                            Toast.makeText(context, "Sign in failed: ${e.message}", Toast.LENGTH_LONG).show()
                        }
                    }
                },
                modifier = Modifier
                    .width(200.dp)
                    .height(48.dp)
            ) {
                Text("Sign in")
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Sign-Up Button
            Button(
                onClick = {
                    // Handle sign-up logic (optional)
                    Toast.makeText(context, "Sign Up clicked", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier
                    .width(200.dp)
                    .height(48.dp)
            ) {
                Text("Sign Up")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen(onLoginSuccess = {})
}
