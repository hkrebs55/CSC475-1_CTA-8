plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    jacoco
}

android {
    namespace = "com.example.csc475_1_cta_8"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.csc475_1_cta_8"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            debug {
                enableUnitTestCoverage = true
                enableAndroidTestCoverage = true
            }
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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

jacoco {
    toolVersion = "0.8.8"
    reportsDirectory = layout.buildDirectory.dir("jacocoReportDir")
}

    dependencies {
        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.appcompat)
        implementation(libs.material)
        implementation(libs.androidx.activity)
        implementation(libs.androidx.constraintlayout)
        implementation(libs.gson)
        implementation(libs.androidx.espresso.contrib)
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)
        debugImplementation(libs.androidx.runner)
        debugImplementation(libs.androidx.rules)
        debugImplementation("org.jacoco:org.jacoco.agent:0.8.8")
    }