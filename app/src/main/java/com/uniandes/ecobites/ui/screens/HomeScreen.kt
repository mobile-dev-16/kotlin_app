import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


    @Composable
    fun HomeScreen() {
        Scaffold(
            topBar = { SearchBar() },
            bottomBar = { BottomNavigation() }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                PromoBanner()
                CategoryRow()
                RestaurantGrid()
            }
        }
    }

    @Composable
    fun SearchBar() {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Search deals...") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }

    @Composable
    fun PromoBanner() {
        // Placeholder for the 50% OFF banner
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        ) {
            Text("50% OFF Promo Banner")
        }
    }

    @Composable
    fun CategoryRow() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CategoryItem("Restaurant")
            CategoryItem("Ingredients")
            CategoryItem("Store")
            CategoryItem("Discounts")
        }
    }

    @Composable
    fun CategoryItem(name: String) {
        Column {
            // Placeholder for icon
            Box(modifier = Modifier.size(48.dp))
            Text(text = name)
        }
    }

    @Composable
    fun RestaurantGrid() {
        // Placeholder for restaurant logos
        Text("Restaurant Grid Here")
    }


    @Composable
    fun BottomNavigation() {
        NavigationBar {
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                label = { Text("Home") },
                selected = true,
                onClick = { }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Filled.ShoppingCart, contentDescription = "Cart") },
                label = { Text("Cart") },
                selected = false,
                onClick = { }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Filled.List, contentDescription = "Orders") },
                label = { Text("Orders") },
                selected = false,
                onClick = { }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
                label = { Text("Profile") },
                selected = false,
                onClick = { }
            )
        }
    }


