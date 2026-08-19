package com.example.keystone

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun KeystoneBottomBar(navController: NavController) {
    // This watches the backstack to see which screen is currently active
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        // 1. Dashboard Button
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Dashboard") },
            label = { Text("Dashboard") },
            selected = currentRoute == "dashboard",
            onClick = {
                navController.navigate("dashboard") {
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )

        // 2. Properties Button
        NavigationBarItem(
            icon = { Icon(Icons.Default.List, contentDescription = "Properties") },
            label = { Text("Properties") },
            selected = currentRoute == "properties",
            onClick = {
                navController.navigate("properties") {
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )

        // 3. Tenants Button
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Tenants") },
            label = { Text("Tenants") },
            selected = currentRoute == "tenants",
            onClick = {
                navController.navigate("tenants") {
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )
    }
}