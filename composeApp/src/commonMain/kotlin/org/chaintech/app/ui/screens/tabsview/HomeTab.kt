package org.chaintech.app.ui.screens.tabsview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import org.chaintech.app.ui.screens.home.HomeView
import org.jetbrains.compose.resources.painterResource
import reelsdemo.composeapp.generated.resources.Res
import reelsdemo.composeapp.generated.resources.tab_home

internal object HomeTab : Tab {
    @Composable
    override fun Content() {
        HomeView()
    }

    override val options: TabOptions
        @Composable
        get() {
            val image = painterResource(Res.drawable.tab_home)
            return remember { TabOptions(index = 0u, title = "Home", icon = image) }
        }
}