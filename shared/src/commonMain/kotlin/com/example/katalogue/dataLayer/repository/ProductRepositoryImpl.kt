package com.example.katalogue.dataLayer.repository

import com.example.katalogue.dataLayer.api.ApiService
import com.example.katalogue.dataLayer.model.Product

class ProductRepositoryImpl(private val apiService: ApiService) : ProductRepository {
    override suspend fun fetchProducts(): List<Product> {
        return apiService.getProducts()
    }

    override suspend fun fetchProductDetail(id: Int): Product {
        return apiService.getProductDetail(id)
    }
}