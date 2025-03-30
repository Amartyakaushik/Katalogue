plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.compose.compiler)
//    id("kotlin-kapt")
//    id("com.google.dagger.hilt.android")
    id("com.google.dagger.hilt.android") version "2.51.1" apply true
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.example.katalogue.android"
    compileSdk = 35
    defaultConfig {
        applicationId = "com.example.katalogue.android"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(projects.shared)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.androidx.activity.compose)
    debugImplementation(libs.compose.ui.tooling)
    implementation(libs.kotlinx.coroutines.android)
    implementation("androidx.navigation:navigation-compose:2.5.3")

    // Hilt dependencies
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("javax.inject:javax.inject:1")
//
//    // ViewModel for Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
}
//kapt {
//    correctErrorTypes = true
//}