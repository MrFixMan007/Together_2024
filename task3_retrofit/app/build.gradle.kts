import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.profsoft_tasks_2024_task3"
    compileSdk = 34

    defaultConfig {
        android.buildFeatures.buildConfig = true
        applicationId = "com.example.profsoft_tasks_2024_task3"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val apiKey: String by lazy {
            val properties = Properties()
            properties.load(rootProject.file("local.properties").inputStream())
            properties.getProperty("API_KEY")
                ?:"is no key"
        }
        buildConfigField ("String", "API_KEY", "\"${apiKey}\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        viewBinding = true
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    api(libs.retrofit)
    implementation(libs.moshiConverter)
    implementation(libs.moshiKotlin)
    implementation(libs.okhttpLoggerInterceptor)
    implementation(libs.chucker)
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
}