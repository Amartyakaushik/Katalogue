package com.example.katalogue.dataLayer.repository

import com.example.katalogue.dataLayer.model.Product

interface ProductRepository {
    suspend fun fetchProducts(): List<Product>
    suspend fun fetchProductDetail(id: Int): Product
}