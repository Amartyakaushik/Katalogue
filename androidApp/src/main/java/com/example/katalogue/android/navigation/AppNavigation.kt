package com.example.katalogue.android.navigation

import ProductDetailScreen
import ProductListScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "productList") {
        composable("productList") {
            ProductListScreen { productId ->
                navController.navigate("productDetail/$productId")
            }
        }
        composable("productDetail/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")?.toIntOrNull() ?: 0
            ProductDetailScreen(productId)
        }
    }
}