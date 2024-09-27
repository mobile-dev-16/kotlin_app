package com.uniandes.ecobites.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uniandes.ecobites.R // Reemplazar con tu propio recurso de íconos


@Composable
fun CartScreen() {
    // Aquí puedes replicar la vista que tienes en la imagen del carrito
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Ejemplo de un título para la pantalla
        Text(text = "Your Cart", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        // Ejemplo de un listado de productos
        // Aquí deberías poner tu implementación que se refleje como la que has mostrado
        Text(text = "Pineapple Pizza - $20,400 COP")
        Text(text = "Donuts - $22,800 COP")
        Text(text = "Cheeseburger - $14,600 COP")

        Spacer(modifier = Modifier.height(16.dp))

        // Ejemplo de botón para checkout
        Button(
            onClick = { /* Acción del botón de checkout */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Checkout")
        }
    }
}

@Composable
fun CartItemCard(item: CartItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Aquí puedes reemplazar la imagen con una imagen de recurso
                Image(
                    painter = painterResource(id = R.drawable.placeholder), // Reemplazar con imagen real
                    contentDescription = item.name,
                    modifier = Modifier
                        .size(64.dp)
                        .background(Color.LightGray, CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = item.name, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(text = item.price, fontSize = 14.sp, color = Color.Gray)
                }
            }

            // Counter for quantity
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* TODO: Decrease quantity */ }) {
                    Text(text = "-", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
                Text(
                    text = item.quantity.toString(),
                    modifier = Modifier.padding(horizontal = 8.dp),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
                IconButton(onClick = { /* TODO: Increase quantity */ }) {
                    Text(text = "+", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = true, // Cambiar esto según la lógica de la navegación
            onClick = { /* TODO: Navegar a Home */ }
        )
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Cart") },
            label = { Text("Cart") },
            selected = false, // Cambiar esto según la lógica de la navegación
            onClick = { /* TODO: Navegar al carrito */ }
        )
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Profile") },
            label = { Text("Profile") },
            selected = false, // Cambiar esto según la lógica de la navegación
            onClick = { /* TODO: Navegar al perfil */ }
        )
    }
}

// Modelo para representar un item del carrito
data class CartItem(
    val name: String,
    val price: String,
    val quantity: Int
)

// Datos de prueba
val cartItems = listOf(
    CartItem("Pineapple Pizza", "20,400 COP", 1),
    CartItem("Donuts", "22,800 COP", 6),
    CartItem("Cheeseburger", "14,600 COP", 1)
)

