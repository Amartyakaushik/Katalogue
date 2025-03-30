import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    kotlin("plugin.serialization") version "2.1.20"
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation(libs.ktor.client.core)
//            implementation(libs.ktor.client.okhttp)
//            implementation(libs.ktor.client.darwin)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.ktor.client.serialization)
//            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
//            implementation("io.coil-kt.coil3:coil-compose:3.1.0")
//            implementation("io.coil-kt.coil3:coil-network-okhttp:3.1.0")
//            implementation("com.google.accompanist:accompanist-pager:0.24.13-rc")

        }
        val androidMain by getting {
            dependencies {
                implementation(libs.ktor.client.okhttp)
                implementation(libs.kotlinx.coroutines.android)
                implementation("javax.inject:javax.inject:1")
                implementation("io.coil-kt:coil-compose:2.1.0")
                implementation("io.coil-kt.coil3:coil-compose:3.1.0")
                implementation("io.coil-kt.coil3:coil-network-okhttp:3.1.0")
                implementation("com.google.accompanist:accompanist-pager:0.24.13-rc")
            }
        }
        val iosMain by creating {
            dependencies {
                implementation(libs.ktor.client.darwin)
            }
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.example.katalogue"
    compileSdk = 35
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
