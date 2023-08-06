import org.jetbrains.kotlin.gradle.plugin.kotlinToolingVersion

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("kotlinx-serialization")
}

kotlin {
    androidTarget()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        version = "1.0.0"
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
        extraSpecAttributes["resources"] = "['src/commonMain/resources/**', 'src/iosMain/resources/**']"
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)

                // IR Added
                implementation(kotlin("stdlib-common"))
                implementation(Coroutines.Core.core)
                implementation(Ktor.Core.common)
                implementation(Ktor.Json.common)
                implementation(Ktor.Logging.common)
                implementation(Ktor.Serialization.common)
                implementation(Ktor.Serialization.content)
                implementation(Ktor.Serialization.json)
                implementation(Kamel.asyncImage)
            }
        }
        val androidMain by getting {
            dependencies {
                api("androidx.activity:activity-compose:1.6.1")
                api("androidx.appcompat:appcompat:1.6.1")
                api("androidx.core:core-ktx:1.9.0")

                // IR Added
                implementation(kotlin("stdlib"))
                implementation(Coroutines.Core.core)
                implementation(Ktor.android)
                implementation(Ktor.Android.okHttp)
                implementation(Ktor.Core.jvm)
                implementation(Ktor.Json.jvm)
                implementation(Ktor.Logging.jvm)
                implementation(Ktor.Logging.slf4j)
                implementation(Ktor.Mock.jvm)

                // UI Tooling
                implementation(compose.uiTooling)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            // IR Added
            dependencies {
                implementation(Ktor.Ios.darvin)
            }
        }
    }
}

android {
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    namespace = "com.inrhythm.lightningtalk"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = (findProperty("android.minSdk") as String).toInt()
        targetSdk = (findProperty("android.targetSdk") as String).toInt()
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.0"
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        jvmToolchain(17)
    }
}
