package com.keystone

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.keystone.screens.DashboardScreen // Imports your actual dashboard!

@Composable
fun KeystoneApp() {
    // This remembers where the user is in the app
    val navController = rememberNavController()

    Scaffold(
        // We will build out the real bottom bar later, but this holds its place
        // bottomBar = { KeystoneBottomBar(navController = navController) }
    ) { innerPadding ->

        // The NavHost is the container that swaps the screens in and out
        NavHost(
            navController = navController,
            startDestination = "dashboard", // The app opens to this screen first
            modifier = Modifier.padding(innerPadding)
        ) {
            // Route 1: The Dashboard
            composable("dashboard") {
                DashboardScreen()
            }

            // Route 2: Properties (Dummy screen for now)
            composable("properties") {
                DummyScreen("Properties Screen - Coming Soon")
            }

            // Route 3: Tenants (Dummy screen for now)
            composable("tenants") {
                DummyScreen("Tenants Screen - Coming Soon")
            }
        }
    }
}

// A temporary placeholder for screens we haven't built yet
@Composable
fun DummyScreen(title: String) {
    Box {
        Text(text = title)
    }
}