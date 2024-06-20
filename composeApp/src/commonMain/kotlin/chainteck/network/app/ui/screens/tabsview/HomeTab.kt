package chainteck.network.app.ui.screens.tabsview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import chainteck.network.app.ui.screens.home.HomeView
import mediaplayer.composeapp.generated.resources.Res
import mediaplayer.composeapp.generated.resources.ic_home_tab
import org.jetbrains.compose.resources.painterResource

internal object HomeTab : Tab {
    @Composable
    override fun Content() {
        HomeView()
    }

    override val options: TabOptions
        @Composable
        get() {
            val image = painterResource(Res.drawable.ic_home_tab)
            return remember { TabOptions(index = 0u, title = "Home", icon = image) }
        }
}