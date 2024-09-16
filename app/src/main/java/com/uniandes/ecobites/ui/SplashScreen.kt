package com.uniandes.ecobites.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uniandes.ecobites.R
import com.uniandes.ecobites.ui.theme.SplashBackground // Import the splash background color

@Composable
fun SplashScreen() {
    // Fullscreen box that centers the logo
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = SplashBackground), // Use the splash background color from Color.kt
        contentAlignment = Alignment.Center
    ) {
        // Use the logo as an Image composable
        Image(
            painter = painterResource(id = R.drawable.icon), // Updated to use icon.xml
            contentDescription = "Eco Bites Logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .width(300.dp)  // Increased width
                .height(300.dp) // Increased height
        )
    }
}

@Preview
@Composable
fun PreviewSplashScreen() {
    SplashScreen()
}
