import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.jetbrains.compose)
}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled = true
                }
            }
        }
        binaries.executable()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(project(":shared"))
            implementation(libs.jetbrains.compose.ui)
            implementation(libs.jetbrains.compose.runtime)
            implementation(libs.jetbrains.compose.foundation)
            implementation(libs.jetbrains.compose.material3)
            implementation(libs.chaintech.media.player)
        }

        val wasmJsMain by getting {
            resources.srcDirs(
                "src/wasmJsMain/resources",
                "../assets",          // 連結根目錄 assets (提供 /git_banner.jpg 等)
                "../assets/wasmJs",    // 連結根目錄 assets/wasmJs (提供 shaka 腳本到根目錄)
                "../composeApp/src/androidMain/assets" // 提供影片資源 1.mp4 等到根目錄
            )
        }
    }
}

tasks.withType<ProcessResources>().configureEach {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
