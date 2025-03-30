package com.example.katalogue.android.ui.productdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.katalogue.dataLayer.model.Product

@Composable
fun ProductDetailScreen(productId: Int, viewModel: ProductDetailViewModel = hiltViewModel()) {
    val product by viewModel.product.collectAsState(initial = null)

    product?.let {
        Column {
            Text(text = it.title)
            Text(text = it.description)
            // Display images in a carousel
            // Show other product details
        }
    }
}