package com.example.mediaplayer.ui.screens.tabsview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.mediaplayer.ui.screens.reels.ReelsContentView
import com.example.mediaplayer.utility.BottomNavigationBarHeight
import org.jetbrains.compose.resources.painterResource
import mediaplayer.shared.generated.resources.Res
import mediaplayer.shared.generated.resources.*
import org.jetbrains.compose.resources.ExperimentalResourceApi

internal object ReelsTab: Tab {
    @Composable
    override fun Content() {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = BottomNavigationBarHeight)
        ){
            ReelsContentView()
        }
    }

    @OptIn(ExperimentalResourceApi::class)
    override val options: TabOptions
        @Composable
        get() {
            val image = painterResource(Res.drawable.ic_foryou_tab)
            return remember { TabOptions(index = 0u, title = "Reels", icon = image) }
        }
}