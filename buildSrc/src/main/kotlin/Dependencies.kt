//import org.gradle.api.JavaVersion
//
//object Config {
//    const val application_id = "com.example.mytranslateproject"
//    const val compile_sdk = 30
//    const val min_sdk = 21
//    const val target_sdk = 30
//    val java_version = JavaVersion.VERSION_1_8
//}
//object Releases {
//    const val version_code = 1
//    const val version_name = "1.0"
//}
//object Modules {
//    const val app = ":app"
//    const val core = ":core"
//    const val model = ":model"
//    const val repository = ":repository"
//    const val utils = ":utils"
//    //Features
//    const val historyScreen = ":historyScreen"
//}
object Versions {
    //Rx-Java
    const val rxandroid = "2.1.0"
    const val rxjava = "2.2.8"
    //Design
    const val appcompat = "1.5.1"
    const val material = "1.7.0"
    //Kotlin
    const val core = "1.9.0"
    const val stdlib = "1.7.10"
    const val coroutinesCore = "1.6.4"
    const val coroutinesAndroid = "1.6.4"
    //Dagger
    const val dagger = "2.44.2"
    const val daggerandr = "2.35.1"
    const val daggersup = "2.35.1"
    //Retrofit
    const val retrofit = "2.6.0"
    const val converterGson = "2.6.0"
    const val interceptor = "3.12.1"
    const val adapterCoroutines = "0.9.2"
    //Picasso
    const val picasso = "2.71828"
    //Koin
    const val koin_core = "3.2.2"
    const val koinAndroid = "3.3.0"

    //Coil
    const val coil = "0.11.0"
    //Room
    const val roomKtx = "2.4.3"
    const val runtime = "2.4.3"
    const val roomCompiler = "2.4.3"
    //Test
    const val jUnit = "4.13.2"
    const val runner = "1.2.0"
    const val extjunit = "1.1.4"
    const val espressoCore = "3.5.0"
    const val cnstrlayout = "2.1.4"
}
object Design {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val cnstrlayout = "androidx.constraintlayout:constraintlayout:${Versions.cnstrlayout}"
}
object Kotlin {
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.stdlib}"
    const val coroutines_core =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    const val coroutines_android =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"
}
object Dagger{
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerandr = "com.google.dagger:dagger-android:${Versions.daggerandr}"
    const val daggersup = "com.google.dagger:dagger-android-support:${Versions.daggersup}"
}
object Rx {
    const val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"
    const val rxjava = "io.reactivex.rxjava2:rxjava::${Versions.rxjava}"
}
object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converter_gson =
        "com.squareup.retrofit2:converter-gson:${Versions.converterGson}"
    const val adapter_coroutines =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.adapterCoroutines}"
    const val logging_interceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"
}
object Koin {
    const val koin_core = "io.insert-koin:koin-core:${Versions.koin_core}"
    const val koin_compat = "io.insert-koin:koin-android-compat:${Versions.koinAndroid}"
    const val koin_workmanager = "io.insert-koin:koin-androidx-workmanager:${Versions.koinAndroid}"
    const val koin_navigation = "io.insert-koin:koin-androidx-navigation:${Versions.koinAndroid}"
    const val koin_android = "io.insert-koin:koin-android:${Versions.koinAndroid}"
    const val koin_view_model =
        "org.koin:koin-android-viewmodel:${Versions.koinAndroid}"
}
object Picasso{
    const val picasso = "com.squareup.picasso:picasso:${Versions.picasso}"
}
object Coil {
    const val coil = "io.coil-kt:coil:${Versions.coil}"
}
object Room {
    const val runtime = "androidx.room:room-runtime:${Versions.runtime}"
    //const val compiler = "androidx.room:room-compiler:${Versions.roomCompiler}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.roomKtx}"
}
object TestImpl {
    const val junit = "junit:junit:${Versions.jUnit}"
    const val extjunit = "androidx.test.ext:${Versions.extjunit}"
    const val runner = "androidx.test:runner:${Versions.runner}"
    const val espresso =
        "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}
