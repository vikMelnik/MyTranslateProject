plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.android")
}


android {
    namespace = "com.example.mytranslateproject"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.mytranslateproject"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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

    implementation(project(":model"))

    //Room
    //implementation(Room.compiler)
    implementation(Room.room_ktx)
    implementation(Room.runtime)
    kapt ("androidx.room:room-compiler:2.4.3")

    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")
    implementation("com.google.firebase:firebase-database-ktx:20.1.0")

    //Download images
    // Coil
    implementation(Coil.coil)

    //Picasso
    implementation(Picasso.picasso)

    //Glide
    implementation("com.github.bumptech.glide:glide:4.11.0")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    kapt("com.github.bumptech.glide:compiler:4.11.0")

    //Koin
    //Текущая версия библиотеки
    //def koin_version = "3.3.0"
    //Koin для поддержки Android (Scope,ViewModel ...)
// Koin main features for Android
    implementation("io.insert-koin:koin-android:3.3.0")
// Java Compatibility
    implementation("io.insert-koin:koin-android-compat:3.3.0")
// Jetpack WorkManager
    implementation("io.insert-koin:koin-androidx-workmanager:3.3.0")
// Navigation Graph
    implementation("io.insert-koin:koin-androidx-navigation:3.3.0")

    // Dagger
    implementation(Dagger.dagger)
    implementation(Dagger.daggerandr)
    implementation(Dagger.daggersup)

    //kapt 'org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.2.0'
    kapt ("com.google.dagger:dagger-compiler:2.43.2")
    kapt ("com.google.dagger:dagger-android-processor:2.35.1")

    //Kotlin
    implementation(Kotlin.stdlib)
    implementation(Kotlin.core)
    implementation(Kotlin.coroutines_core)
    implementation(Kotlin.coroutines_android)

    // Rx-Java
    implementation(Rx.rxandroid)
    //implementation(Rx.rxjava)
    //implementation("io.reactivex.rxjava2:rxandroid:2.1.0")
    implementation("io.reactivex.rxjava2:rxjava:2.2.8")

    // Retrofit 2
    implementation(Retrofit.retrofit)
    implementation(Retrofit.logging_interceptor)
    implementation(Retrofit.converter_gson)
    implementation(Retrofit.adapter_coroutines)

    // Design
    implementation(Design.appcompat)
    implementation(Design.material)
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //Test
    testImplementation(TestImpl.junit)
    androidTestImplementation(TestImpl.extjunit)
    androidTestImplementation(TestImpl.espresso)
}

