pluginManagement {
    repositories {
        gradlePluginPortal()
        maven(url = "https://plugins.gradle.org/m2/")
        mavenCentral()
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots")
            name = "SonatypeSnapshots"
            mavenContent {
                snapshotsOnly()
            }
        }
        maven(url = "https://maven.aliyun.com/repository/gradle-plugin/")
        maven(url = "https://maven.aliyun.com/repository/spring-plugin/")
        maven(url = "https://jitpack.io")
        maven(url = "https://s3.amazonaws.com/repo.commonsware.com")
        maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven(url = "https://api.xposed.info/")
        maven(url = "https://jogamp.org/deployment/maven")
        maven(url = "https://developer.huawei.com/repo/")
        maven(url = "https://raw.githubusercontent.com/cybernhl/maven-repository/master/")
        maven(url = "https://maven.aliyun.com/repository/jcenter")
        maven(url = "https://maven.aliyun.com/repository/public/")
        maven(url = "https://maven.aliyun.com/repository/spring/")
        maven(url = "https://maven.aliyun.com/repository/google/")
        maven(url = "https://maven.aliyun.com/repository/grails-core/")
        maven(url = "https://maven.aliyun.com/repository/apache-snapshots/")
        maven(url = "https://packages.jetbrains.team/maven/p/skija/maven")
    }
    plugins {

    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

val fullVersion = System.getProperty("java.version", "8.0.0")
val versionComponents = fullVersion
    .split(".")
    .take(2)
    .filter { it.isNotBlank() }
    .map { Integer.parseInt(it) }

val currentJdk = if (versionComponents[0] == 1) versionComponents[1] else versionComponents[0]


@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots")
            name = "SonatypeSnapshots"
            mavenContent {
                snapshotsOnly()
            }
        }
        maven(url = "https://jitpack.io")
        maven(url = "https://s3.amazonaws.com/repo.commonsware.com")
        maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven(url = "https://api.xposed.info/")
        maven(url = "https://jogamp.org/deployment/maven")
        maven(url = "https://raw.githubusercontent.com/cybernhl/maven-repository/master/")
        maven(url = "https://maven.aliyun.com/repository/jcenter")
        maven(url = "https://maven.aliyun.com/repository/public/")
        maven(url = "https://maven.aliyun.com/repository/spring/")
        maven(url = "https://maven.aliyun.com/repository/google/")
        maven(url = "https://packages.jetbrains.team/maven/p/skija/maven")
    }
}

rootProject.name = "ReelsDemo"
include(":shared")
project(":shared").projectDir = file("./composeApp")

include(":desktopApp")
include(":androidApp")
include(":webApp")

//include(":compose-multiplatform-media-player")
//project(":compose-multiplatform-media-player").projectDir = file("./compose-multiplatform-media-player/media_player")

//include(":core")
//project(":core").projectDir = file("./compose-multiplatform-media-player/JavaCvPlayer/core")
//include(":core-video-swing")
//project(":core-video-swing").projectDir = file("./compose-multiplatform-media-player/JavaCvPlayer/core-video-swing")
//include(":core_ui_compose")
//project(":core_ui_compose").projectDir = file("./compose-multiplatform-media-player/JavaCvPlayer/core_ui_compose")
//include(":core-video-javafx")
//project(":core-video-javafx").projectDir = file("./compose-multiplatform-media-player/JavaCvPlayer/core-video-javafx")
//include(":core-video-compose-jvm")
//project(":core-video-compose-jvm").projectDir = file("./compose-multiplatform-media-player/JavaCvPlayer/core-video-compose-jvm")
//include(":core-video-skia")
//project(":core-video-skia").projectDir = file("./compose-multiplatform-media-player/JavaCvPlayer/core-video-skia")