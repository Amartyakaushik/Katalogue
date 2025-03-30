package com.example.katalogue

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform