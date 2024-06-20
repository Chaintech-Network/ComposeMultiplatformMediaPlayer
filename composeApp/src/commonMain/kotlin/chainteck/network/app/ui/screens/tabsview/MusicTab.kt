package chainteck.network.app.ui.screens.tabsview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import chainteck.network.app.ui.screens.music.MusicContentView
import chainteck.network.app.ui.screens.reels.ReelsContentView
import chainteck.network.app.utility.BottomNavigationBarHeight
import mediaplayer.composeapp.generated.resources.Res
import mediaplayer.composeapp.generated.resources.ic_foryou_tab
import mediaplayer.composeapp.generated.resources.ic_music_tab
import org.jetbrains.compose.resources.painterResource

internal object MusicTab: Tab {
    @Composable
    override fun Content() {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = BottomNavigationBarHeight)
        ){
            MusicContentView()
        }
    }

    override val options: TabOptions
        @Composable
        get() {
            val image = painterResource(Res.drawable.ic_music_tab)
            return remember { TabOptions(index = 0u, title = "Music", icon = image) }
        }
}