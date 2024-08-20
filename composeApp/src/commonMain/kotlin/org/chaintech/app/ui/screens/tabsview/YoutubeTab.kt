package org.chaintech.app.ui.screens.tabsview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import org.chaintech.app.ui.screens.youtube.YoutubeContentView
import org.chaintech.app.utility.BottomNavigationBarHeight
import org.jetbrains.compose.resources.painterResource
import reelsdemo.composeapp.generated.resources.Res
import reelsdemo.composeapp.generated.resources.tab_youtube

internal object YoutubeTab: Tab {
    @Composable
    override fun Content() {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = BottomNavigationBarHeight)
        ){
            YoutubeContentView()
        }
    }

    override val options: TabOptions
        @Composable
        get() {
            val image = painterResource(Res.drawable.tab_youtube)
            return remember { TabOptions(index = 0u, title = "YouTube", icon = image) }
        }
}