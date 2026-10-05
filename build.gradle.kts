buildscript {
    // 在 Kotlin DSL 中，使用 extra 屬性來代替 Groovy 的 ext
    extra.apply {
        set("agp_gradle", libs.versions.agp.get())

        var tempKotlinVersion = "1.9.25"
        println("Show  kotlin_version  : $tempKotlinVersion")

        tempKotlinVersion = libs.versions.kotlin.get()
        set("kotlin_version", tempKotlinVersion)
        println("Show  kotlin_version from lib.version.toml  : $tempKotlinVersion")

        set("coroutine_version", "1.6.4")
        set("jb_compose_version", libs.versions.jetbrains.compose.multiplatform.get())
        set("navigation_version", libs.versions.androidx.navigation.get())
    }

    // 從 extra 中讀取值以供後續使用
    val kotlin_version: String by extra
    println("Show  fianl kotlin_version  : $kotlin_version")

    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
        maven {
            url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        }
    }
    dependencies {
        val agp_gradle: String by extra
//        classpath("com.android.tools.build:gradle:$agp_gradle")
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
//        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlin_version")
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.android.kotlin.multiplatform.library) apply false

    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false

    alias(libs.plugins.jetbrains.compose) apply false
    alias(libs.plugins.compose.compiler) apply false

    alias(libs.plugins.kotlin.serialization) apply false

    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.mavenPublish) apply false
}

allprojects {
    tasks.findByName("run")?.let { task ->
        if (task is JavaExec) {
            println(">>> [afterEvaluate] 'run' task workingDir is: ${task.workingDir}")
            println(">>> [afterEvaluate] 'run' task commandLine is: ${task.commandLine.joinToString(" ")}")
        } else {
            println(">>> [afterEvaluate] 'run' task found, but it's not a JavaExec task. Type: ${task::class.java.name}")
        }
    } ?: println(">>> [afterEvaluate] 'run' task NOT found.")
    afterEvaluate {
    }
}

subprojects {
    afterEvaluate {
    }
}
