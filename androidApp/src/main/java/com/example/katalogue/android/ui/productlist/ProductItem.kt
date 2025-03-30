package com.example.katalogue.android.ui.productlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.katalogue.dataLayer.model.Product

@Composable
fun ProductItem(product: Product, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .clickable { onClick() }
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = product.title, style = androidx.compose.material3.MaterialTheme.typography.titleMedium)
            Text(text = product.description, style = androidx.compose.material3.MaterialTheme.typography.bodyMedium)
            // You can add an image loader like Coil here to display product images
        }
    }
}