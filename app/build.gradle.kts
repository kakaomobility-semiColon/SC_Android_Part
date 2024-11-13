import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")


}

val properties = Properties()
properties.load(project.rootProject.file("local.properties").inputStream())



android {
    namespace = "com.main.sc_android_part"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.main.sc_android_part"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "KAKAO_APP_KEY", properties.getProperty("KAKAO_APP_KEY"))



        ndk {
            abiFilters.add("arm64-v8a")
            abiFilters.add("armeabi-v7a")
            abiFilters.add("x86")
            abiFilters.add("x86_64")
        }



        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            manifestPlaceholders["KAKAO_APP_KEY"] = properties["KAKAO_APP_KEY"].toString()
        }
        release {
            isMinifyEnabled = false
            manifestPlaceholders["KAKAO_APP_KEY"] = properties["KAKAO_APP_KEY"].toString()
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
    buildFeatures {
        compose = true
        buildConfig = true
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

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.3")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.navigation:navigation-compose:2.5.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation ("com.kakao.maps.open:android:2.11.9")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("com.kakao.sdk:v2-all:2.11.2") // 전체 모듈 설치, 2.11.0 버전부터 지원
    implementation ("com.kakao.sdk:v2-user:2.11.2") // 카카오 로그인
    implementation ("com.kakao.sdk:v2-talk:2.11.2") // 친구, 메시지(카카오톡)
    implementation ("com.kakao.sdk:v2-story:2.11.2") // 카카오스토리
    implementation ("com.kakao.sdk:v2-share:2.11.2") // 메시지(카카오톡 공유)
    implementation ("com.kakao.sdk:v2-navi:2.11.2") // 카카오내비
    implementation ("com.kakao.sdk:v2-friend:2.11.2") // 카카오톡 소셜 피커, 리소스 번들 파일 포함

    implementation ("androidx.compose.material:material-icons-extended:1.7.5")

}