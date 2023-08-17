val kotlinVersion: String by project
val androidXCoreVersion: String by project
val androidXLifecycleVersion: String by project
val androidXActivityComposeVersion: String by project
val androidXNavComposeVersion: String by project
val androidXSplashScreenVersion: String by project
val composeBomVersion: String by project
val timberVersion: String by project
val daggerHiltVersion: String by project

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")
}

android {
    namespace = "com.jianastrero.templateandroidapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.jianastrero.templateandroidapp"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.jianastrero.templateandroidapp.runner.HiltTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isDebuggable = true
        }
        release {
            isDebuggable = false // Disable this if you want to debug
            isMinifyEnabled = true // Disable this if you want to debug
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
        kotlinCompilerExtensionVersion = "1.5.0"
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

    // Timber
    implementation("com.jakewharton.timber:timber:$timberVersion")

    // Dagger Hilt
    implementation("com.google.dagger:hilt-android:$daggerHiltVersion")
    kapt("com.google.dagger:hilt-compiler:$daggerHiltVersion")

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
