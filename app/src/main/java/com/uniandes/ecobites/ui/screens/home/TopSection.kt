package com.uniandes.ecobites.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Close
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview

// Top Section with Location and Search Bar
@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopSection() {
    var query by remember { mutableStateOf("") }
    var isActive by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Location Row
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
        ) {
            Icon(Icons.Outlined.LocationOn, contentDescription = "Location", tint = Color.Gray)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Calle 13 #10-22", style = MaterialTheme.typography.bodyMedium)
        }
        Spacer(modifier = Modifier.height(8.dp))

        // Material 3 Search Bar with Size Constraint
        SearchBar(
            query = query,
            onQueryChange = { query = it },
            onSearch = {
                // Handle search logic
            },
            active = isActive,
            onActiveChange = { isActive = it },
            placeholder = { Text("Search deals...") },
            leadingIcon = { Icon(Icons.Outlined.Search, contentDescription = "Search Icon") },
            trailingIcon = {
                if (query.isNotEmpty()) {
                    IconButton(onClick = { query = "" }) {
                        Icon(Icons.Outlined.Close, contentDescription = "Clear")
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth() // Ensure it fills the parent width properly
                .heightIn(min = 56.dp, max = 72.dp) // Control the min and max height
                .padding(horizontal = 8.dp) // Add some padding
        ) {
            // You can provide additional content here if needed
        }
    }
}
