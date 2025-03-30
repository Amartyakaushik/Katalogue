package com.example.katalogue.domain.usecase

import com.example.katalogue.dataLayer.model.Product
import com.example.katalogue.dataLayer.repository.ProductRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(): List<Product> {
        return repository.fetchProducts()
    }
}

//annotation class Inject
