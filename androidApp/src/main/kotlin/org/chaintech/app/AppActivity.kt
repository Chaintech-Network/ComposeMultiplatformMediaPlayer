package org.chaintech.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import chaintech.videoplayer.util.PlaybackPreference

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PlaybackPreference.initialize(this)
        setContent { MainView() }
    }
}