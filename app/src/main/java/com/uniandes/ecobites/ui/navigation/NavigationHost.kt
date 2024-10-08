package com.uniandes.ecobites.ui.navigation

import androidx.compose.runtime.Composable
import com.uniandes.ecobites.ui.screens.ProfileScreen
import com.uniandes.ecobites.ui.screens.CartScreen
import com.uniandes.ecobites.ui.screens.home.HomeScreen
import com.uniandes.ecobites.ui.screens.OrdersScreen

@Composable
fun NavigationHost(selectedTab: Int) {
    when (selectedTab) {
        0 -> HomeScreen()
        1 -> CartScreen()
        2 -> OrdersScreen()
        3 -> ProfileScreen()
        else -> HomeScreen()
    }
}
