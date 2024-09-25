package com.uniandes.ecobites.ui.navigation

import androidx.compose.runtime.Composable
import com.uniandes.ecobites.ui.screens.CartScreen
import HomeScreen
import com.uniandes.ecobites.ui.screens.OrdersScreen
import com.uniandes.ecobites.ui.screens.ProfileScreen

@Composable
fun NavigationHost(selectedTab: Int) {
    when (selectedTab) {
        0 -> HomeScreen()
        1 -> CartScreen()
        2 -> OrdersScreen()
        3 -> ProfileScreen()
    }
}
