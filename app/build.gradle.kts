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

    //Room
    implementation("androidx.room:room-runtime:2.4.3")
    kapt ("androidx.room:room-compiler:2.4.3")
    implementation("androidx.room:room-ktx:2.4.3")

    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")
    implementation("com.google.firebase:firebase-database-ktx:20.1.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    //Download images
// Coil
    implementation("com.squareup.picasso:picasso:2.71828")

//Picasso
    implementation("com.squareup.picasso:picasso:2.71828")
//Glide
    implementation("com.github.bumptech.glide:glide:4.11.0")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    kapt("com.github.bumptech.glide:compiler:4.11.0")

    //Koin
//Текущая версия библиотеки
    //def koin_version = "3.3.0"

//Koin для поддержки Android (Scope,ViewModel ...)
    implementation("io.insert-koin:koin-android:3.3.0")
// Dagger
    implementation("com.google.dagger:dagger:2.44.2")
    implementation("com.google.dagger:dagger-android:2.35.1")
    implementation("com.google.dagger:dagger-android-support:2.35.1")

    //kapt 'org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.2.0'
    kapt ("com.google.dagger:dagger-compiler:2.43.2")
    kapt ("com.google.dagger:dagger-android-processor:2.35.1")

//Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.10")
    implementation("androidx.core:core-ktx:1.9.0")

// Rx-Java
    implementation("io.reactivex.rxjava2:rxandroid:2.1.0")
    implementation("io.reactivex.rxjava2:rxjava:2.2.8")
// Retrofit 2
    implementation("com.squareup.retrofit2:retrofit:2.6.0")
    implementation("com.squareup.retrofit2:converter-gson:2.6.0")
    implementation("com.squareup.okhttp3:logging-interceptor:3.12.1")
    implementation("com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0")
// Test
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.7.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.4")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")
}