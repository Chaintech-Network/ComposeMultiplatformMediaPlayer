import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.android.library)
}

kotlin {
    androidTarget {
        publishLibraryVariants("release", "debug")
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                    freeCompilerArgs.add("-Xjdk-release=${JavaVersion.VERSION_1_8}")
                }
            }
        }
    }

    jvm()

    val xcfName = "ComposeApp"
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = xcfName
            isStatic = true
            binaryOption("bundleId", "org.chaintech.app")
        }
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
    }

    sourceSets {
        all {
            languageSettings {
                optIn("org.jetbrains.compose.resources.ExperimentalResourceApi")
            }
        }
        commonMain.dependencies {
            implementation(libs.jetbrains.compose.runtime)
            implementation(libs.jetbrains.compose.foundation)
            implementation(libs.jetbrains.compose.material.icons.extended)
            implementation(libs.jetbrains.compose.material)
            implementation(libs.jetbrains.compose.material3)
            implementation(libs.jetbrains.compose.components.resources)
            implementation(libs.jetbrains.compose.ui.tooling.preview)

            implementation(libs.voyager.navigator)
            implementation(libs.voyager.transitions)
            implementation(libs.voyager.tab)
            implementation(libs.sdp.ssp)
            implementation(libs.image.loader)
            implementation(libs.media.kit)

            // 編譯期僅供符號引用，不打包進 Runtime (Shadowing 策略)
            compileOnly(libs.chaintech.media.player)
        }

        androidMain.dependencies {
            implementation(libs.jetbrains.compose.ui.tooling)
            implementation(libs.androidx.activity.compose)
            implementation(libs.chaintech.media.player) // Android 運行時使用遠端庫
        }

        iosMain.dependencies {
            implementation(libs.chaintech.media.player) // iOS 運行時使用遠端庫
        }

        wasmJsMain.dependencies {
            implementation(libs.chaintech.media.player) // Web 運行時使用遠端庫
        }

        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation("com.github.cybernhl.ComposeMultiplatformMediaPlayer:compose-multiplatform-media-player:1.0.54")
//            api(project(":compose-multiplatform-media-player"))
        }
    }
}

android {
    namespace = "org.chaintech.app"
    compileSdk = 37
    buildFeatures {
        compose = true
    }
    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    sourceSets["main"].apply {
        manifest.srcFile("src/androidMain/AndroidManifest.xml")
        res.srcDirs("src/androidMain/res")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

compose.resources {
    publicResClass = true
    packageOfResClass = "reelsdemo.composeapp.generated.resources"
    generateResClass = always
}