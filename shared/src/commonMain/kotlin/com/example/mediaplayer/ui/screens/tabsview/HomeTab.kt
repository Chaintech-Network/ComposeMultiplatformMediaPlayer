package com.example.mediaplayer.ui.screens.tabsview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.mediaplayer.ui.screens.home.HomeView
import mediaplayer.shared.generated.resources.Res
import mediaplayer.shared.generated.resources.ic_home_tab
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

internal object HomeTab : Tab {
    @Composable
    override fun Content() {
        HomeView()
    }

    @OptIn(ExperimentalResourceApi::class)
    override val options: TabOptions
        @Composable
        get() {
            val image = painterResource(Res.drawable.ic_home_tab)
            return remember { TabOptions(index = 0u, title = "Home", icon = image) }
        }
}