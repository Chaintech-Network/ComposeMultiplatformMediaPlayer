package org.chaintech.app

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import chaintech.network.connectivitymonitor.ConnectivityMonitor
import chaintech.videoplayer.util.PlaybackPreference

class AndroidApp : Application() {
    companion object {
        lateinit var INSTANCE: AndroidApp
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ConnectivityMonitor.initialize(this)
        PlaybackPreference.initialize(this)
        setContent { MainView() }
    }
}