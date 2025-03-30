package com.example.katalogue.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.katalogue.android.ui.productlist.ProductListScreen
import com.example.katalogue.android.ui.productdetail.ProductDetailScreen

//@Composable
//fun AppNavigation() {
//    val navController = rememberNavController()
//
//    NavHost(navController, startDestination = "productList") {
//        composable("productList") { ProductListScreen() }
//        composable("productDetail/{productId}") { backStackEntry ->
//            val productId = backStackEntry.arguments?.getString("productId")?.toInt() ?: 0
//            ProductDetailScreen(productId)
//        }
//    }
//}
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