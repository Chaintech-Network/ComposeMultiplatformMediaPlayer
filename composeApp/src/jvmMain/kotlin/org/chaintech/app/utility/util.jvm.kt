package org.chaintech.app.utility

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import java.io.File
import java.io.FileOutputStream
import java.nio.file.Files

@Composable
actual fun SystemAppearance() {
}

actual fun getSafeAreaHeight(): SafeAreaSize {
    return SafeAreaSize()
}

/**
 * 修正 JVM 端的資源路徑獲取邏輯。
 * 由於 FFmpeg (JavaCV) 無法直接讀取 JAR 內的資源，
 * 我們必須將資源提取到臨時檔案後，返回該檔案的絕對路徑。
 */
actual fun getLocalFilePathFor(item: String): String {
    val classLoader = Thread.currentThread().contextClassLoader
    val resourceStream = classLoader.getResourceAsStream(item)
    
    if (resourceStream == null) {
        println("⚠️ 找不到資源: $item")
        return ""
    }

    return try {
        // 在系統臨時目錄建立一個具有原始檔名後綴的暫存檔
        val extension = item.substringAfterLast('.', "tmp")
        val tempFile = Files.createTempFile("cv_player_res_", ".$extension").toFile()
        tempFile.deleteOnExit() // 程式結束時自動刪除

        resourceStream.use { input ->
            FileOutputStream(tempFile).use { output ->
                input.copyTo(output)
            }
        }
        
        println("✅ 資源已提取至臨時路徑: ${tempFile.absolutePath}")
        tempFile.absolutePath
    } catch (e: Exception) {
        println("❌ 提取資源失敗: ${e.message}")
        ""
    }
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
actual fun screenWidth(): Float {
    val density = LocalDensity.current
    val screenSize = LocalWindowInfo.current.containerSize
    val width = with(density) { screenSize.width.toDp() }
    return width.value
}
