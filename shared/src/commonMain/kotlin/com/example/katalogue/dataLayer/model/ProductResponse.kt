package com.example.katalogue.dataLayer.model

import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    val products: List<Product>,
    val total: Int,
    val skip: Int,
    val limit: Int
)