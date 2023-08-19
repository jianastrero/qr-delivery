import java.io.FileInputStream
import java.util.*

val appPackageName: String by project
val appVersionCode: String by project
val appVersionName: String by project

val kotlinVersion: String by project
val androidXCoreVersion: String by project
val androidXLifecycleVersion: String by project
val androidXActivityComposeVersion: String by project
val androidXNavComposeVersion: String by project
val androidXSplashScreenVersion: String by project
val composeBomVersion: String by project
val timberVersion: String by project
val daggerHiltVersion: String by project
val firebaseBomVersion: String by project
val cameraXVersion: String by project
val mlkitBarcodeScanning: String by project

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id("com.google.firebase.firebase-perf")
}

android {
    namespace = appPackageName
    compileSdk = 34

    defaultConfig {
        applicationId = appPackageName
        minSdk = 24
        targetSdk = 34
        versionCode = appVersionCode.toInt()
        versionName = appVersionName

        testInstrumentationRunner = "${appPackageName}.runner.HiltTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    val localProperties = Properties().apply {
        FileInputStream(rootProject.file("local.properties")).use { load(it) }
    }

    signingConfigs {
        create("release") {
            val releaseStoreFile = localProperties.getProperty("storeFile")?.let { File(it) }
            if (releaseStoreFile == null) {
                println("The storeFile property is not set in the local.properties file.")
            } else {
                storeFile = releaseStoreFile
                keyAlias = localProperties.getProperty("keyAlias")
                keyPassword = localProperties.getProperty("keyPassword")
                storePassword = localProperties.getProperty("storePassword")
            }
        }
    }

    buildTypes {
        debug {
            isDebuggable = true
        }
        release {
            isDebuggable = false // Disable this if you want to debug
            isMinifyEnabled = true // Disable this if you want to debug
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")

    // Main AndroidX Dependencies
    implementation("androidx.core:core-ktx:$androidXCoreVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$androidXLifecycleVersion")
    implementation("androidx.activity:activity-compose:$androidXActivityComposeVersion")
    implementation("androidx.navigation:navigation-compose:$androidXNavComposeVersion")
    implementation("androidx.core:core-splashscreen:$androidXSplashScreenVersion")

    // Compose Dependencies
    implementation(platform("androidx.compose:compose-bom:$composeBomVersion"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-extended")

    // CameraX
    implementation( "androidx.camera:camera-core:${cameraXVersion}")
    implementation( "androidx.camera:camera-camera2:${cameraXVersion}")
    implementation( "androidx.camera:camera-lifecycle:${cameraXVersion}")
    implementation( "androidx.camera:camera-video:${cameraXVersion}")
    implementation( "androidx.camera:camera-view:${cameraXVersion}")
    implementation( "androidx.camera:camera-extensions:${cameraXVersion}")

    // Timber
    implementation("com.jakewharton.timber:timber:$timberVersion")

    // Dagger Hilt
    implementation("com.google.dagger:hilt-android:$daggerHiltVersion")
    kapt("com.google.dagger:hilt-compiler:$daggerHiltVersion")

    // Firebase
    implementation(platform("com.google.firebase:firebase-bom:$firebaseBomVersion"))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-crashlytics-ktx")
    implementation("com.google.firebase:firebase-perf-ktx")

    // MLKit
    implementation("com.google.android.gms:play-services-mlkit-barcode-scanning:$mlkitBarcodeScanning")

    // Compose Permissions
    implementation("dev.jianastrero:compose-permissions:1.0.1")

    // Unit Test Dependencies
    testImplementation("junit:junit:4.13.2")

    // Android Test Dependencies
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    androidTestImplementation("com.google.dagger:hilt-android-testing:$daggerHiltVersion")
    kaptAndroidTest("com.google.dagger:hilt-compiler:$daggerHiltVersion")

    // Debug Dependencies
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
