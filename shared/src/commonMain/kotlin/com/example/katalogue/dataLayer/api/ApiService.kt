package com.example.katalogue.dataLayer.api

import com.example.katalogue.dataLayer.model.Product

interface ApiService {
    suspend fun getProducts(): List<Product>
    suspend fun getProductDetail(id: Int): Product
}