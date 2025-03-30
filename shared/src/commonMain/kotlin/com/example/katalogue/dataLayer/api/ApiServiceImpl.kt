package com.example.katalogue.dataLayer.api

import com.example.katalogue.dataLayer.model.Product
import com.example.katalogue.dataLayer.model.ProductResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class ApiServiceImpl : ApiService {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    override suspend fun getProducts(): List<Product> {
        val response: ProductResponse = client.get("https://dummyjson.com/products").body()
        return response.products
    }

    override suspend fun getProductDetail(id: Int): Product {
        return client.get("https://dummyjson.com/products/$id").body()
    }
}

//package com.example.katalogue.dataLayer.api
//
//import com.example.katalogue.dataLayer.model.Product
//import io.ktor.client.*
//import io.ktor.client.call.*
//import io.ktor.client.plugins.contentnegotiation.*
//import io.ktor.client.request.*
//import io.ktor.serialization.kotlinx.json.*
//import kotlinx.serialization.json.Json
//
//class ApiServiceImpl : ApiService {
//    private val client = HttpClient {
//        install(ContentNegotiation) {
//            json(Json { ignoreUnknownKeys = true })
//        }
//    }
//
//    override suspend fun getProducts(): List<Product> {
//        return client.get("https://dummyjson.com/products").body()
//    }
//
//    override suspend fun getProductDetail(id: Int): Product {
//        return client.get("https://dummyjson.com/products/$id").body()
//    }
//}