@file:Suppress("DSL_SCOPE_VIOLATION")

//@file:Suppress("OPT_IN_IS_NOT_ENABLED")
import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.compose)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            binaryOption("bundleId", "com.ixfi.staging")
            binaryOption("bundleVersion", "1")
        }
    }

//    iosX64()
//    iosArm64()
//    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "16.0"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
                dependencies {
                    /*compose*/
                    implementation(compose.runtime)
                    implementation(compose.foundation)
                    implementation(compose.material)
                    implementation(compose.material3)
                    implementation(compose.animation)
                    @OptIn(ExperimentalComposeLibrary::class)
                    implementation(compose.components.resources)

                    /*coroutines*/
                    implementation(libs.kotlinx.coroutines.core)
                    /* ********************* */

                    /* Navigation use */
                    /* Navigator */
                    implementation(libs.voyager.navigator)
                    /* Transitions */
                    implementation(libs.voyager.transitions)
                    /* TabNavigator */
                    implementation(libs.voyager.tab)
                    /* ********************* */

                    implementation("network.chaintech:compose-multiplatform-media-player:1.0.7")
                    implementation("network.chaintech:sdp-ssp-compose-multiplatform:1.0.0")
                    api("io.github.qdsfdhvh:image-loader:1.6.7")
                }
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
        val androidMain by getting {
            dependencies {
                api(libs.android.accompanist.systemuicontroller)
                api(libs.android.activity.compose)
                api(libs.android.appcompat)
                api(libs.android.core.ktx)
                implementation(libs.android.koin.core)
                implementation(libs.android.kotlinx.coroutines)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by getting {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
            }
        }
    }
}

android {
    namespace = "com.example.mediaplayer"
    compileSdk = 34

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].apply {
        res.srcDirs("src/commonMain/composeResources")
        resources.srcDirs("src/commonMain/composeResources")
    }

    defaultConfig {
        minSdk = 24
    }
}

