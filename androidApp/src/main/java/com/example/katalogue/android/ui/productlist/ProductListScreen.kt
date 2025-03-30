//package com.example.katalogue.android.ui.productlist
//
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.material3.Card
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Modifier
//import androidx.hilt.navigation.compose.hiltViewModel
//import com.example.katalogue.dataLayer.model.Product
//
//@Composable
//fun ProductListScreen(viewModel: ProductListViewModel = hiltViewModel(), onProductClick: (Int) -> Unit) {
//    val products by viewModel.products.collectAsState()
//
//    LazyColumn {
//        items(products) { product ->
//            ProductItem(product) {
//                onProductClick(product.id) // Pass the product ID
//            }
//        }
//    }
//}
//
//@Composable
//fun ProductItem(product: Product, onClick: () -> Unit) {
//    Card(modifier = Modifier.clickable { onClick() }) {
//        Column {
//            Text(text = product.title)
//            Text(text = product.description)
//            // Load image using Coil or similar library
//        }
//    }
//}

package com.example.katalogue.android.ui.productlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items // Ensure this import is present
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.katalogue.dataLayer.model.Product

@Composable
fun ProductListScreen(viewModel: ProductListViewModel = hiltViewModel(), onProductClick: (Int) -> Unit) {
    val products by viewModel.products.collectAsState()

    LazyColumn {
        items(products) { product ->
            ProductItem(product) {
                onProductClick(product.id) // Ensure Product has an id property
            }
        }
    }
}

//@Composable
//fun ProductItem(product: Product, onClick: () -> Unit) {
//    Card(modifier = Modifier.clickable { onClick() }) {
//        Column {
//            Text(text = product.title)
//            Text(text = product.description)
//            // Load image using Coil or similar library
//        }
//    }
//}