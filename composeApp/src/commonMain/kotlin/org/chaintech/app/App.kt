package org.chaintech.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator
import cafe.adriel.voyager.transitions.SlideTransition
import chaintech.videoplayer.util.isDesktop
import network.chaintech.sdpcomposemultiplatform.sdp
import org.chaintech.app.font.FontType
import org.chaintech.app.font.MediaFont
import org.chaintech.app.navigation.LocalNavigation
import org.chaintech.app.navigation.LocalScreenContainer
import org.chaintech.app.navigation.NavigationProvider
import org.chaintech.app.navigation.ScreenContainerProvider
import org.chaintech.app.theme.MyApplicationTheme
import org.chaintech.app.ui.screens.tabs.HomeTab
import org.chaintech.app.ui.screens.tabs.MusicTab
import org.chaintech.app.ui.screens.tabs.ReelsTab
import org.chaintech.app.ui.screens.tabs.YoutubeTab
import org.chaintech.app.utility.BottomNavigationBarHeight
import org.chaintech.app.utility.getSafeAreaSize

@Composable
fun MainView() {
    val tabs: List<Tab> = listOf(HomeTab, ReelsTab, MusicTab, YoutubeTab)

    MyApplicationTheme {
        val navigation = remember { NavigationProvider() }
        val screenContainer = remember { ScreenContainerProvider() }

        CompositionLocalProvider(
            LocalScreenContainer provides screenContainer,
            LocalNavigation provides navigation,
        ) {
            Box(Modifier.fillMaxSize()) {
                TabNavigator(
                    HomeTab,
                    tabDisposable = {
                        TabDisposable(
                            navigator = it,
                            tabs = tabs
                        )
                    }
                ) {
                    Navigator(HomeScreen()) {
                        navigation.initialize()
                        SlideTransition(it)
                    }
                }
            }
        }
    }
}

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        Scaffold(
            modifier = Modifier
                .background(color = MyApplicationTheme.colors.bottomTabBarColor)
                .padding(bottom = getSafeAreaSize().bottom.dp),
            scaffoldState = rememberScaffoldState(),
            backgroundColor = MyApplicationTheme.colors.bottomTabBarColor,
            bottomBar = { if (!isDesktop()) BottomNavigationBar() }
        ) {
            Row {
                if (isDesktop()) {
                    DesktopNavigation()
                }
                CurrentTab()
            }
        }
    }

    @Composable
    private fun BottomNavigationBar() {
        BottomNavigation(
            modifier = Modifier.height(BottomNavigationBarHeight),
            contentColor = MyApplicationTheme.colors.bottomTabBarColor,
            backgroundColor = MyApplicationTheme.colors.bottomTabBarColor,
        ) {
            TabNavigationItem(tab = HomeTab)
            TabNavigationItem(tab = ReelsTab)
            TabNavigationItem(tab = MusicTab)
            TabNavigationItem(tab = YoutubeTab)
        }
    }

    @Composable
    private fun DesktopNavigation() {
        Column(
            modifier = Modifier.width(50.sdp).fillMaxHeight()
        ) {
            BottomNavigation(
                modifier = Modifier
                    .height(BottomNavigationBarHeight),
                contentColor = MyApplicationTheme.colors.bottomTabBarColor,
                backgroundColor = MyApplicationTheme.colors.bottomTabBarColor,
            ) {
                TabNavigationItem(tab = HomeTab)
            }
            BottomNavigation(
                modifier = Modifier
                    .height(BottomNavigationBarHeight),
                contentColor = MyApplicationTheme.colors.bottomTabBarColor,
                backgroundColor = MyApplicationTheme.colors.bottomTabBarColor,
            ) {
                TabNavigationItem(tab = ReelsTab)
            }

            BottomNavigation(
                modifier = Modifier
                    .height(BottomNavigationBarHeight),
                contentColor = MyApplicationTheme.colors.bottomTabBarColor,
                backgroundColor = MyApplicationTheme.colors.bottomTabBarColor,
            ) {
                TabNavigationItem(tab = MusicTab)
            }

            BottomNavigation(
                modifier = Modifier
                    .height(BottomNavigationBarHeight),
                contentColor = MyApplicationTheme.colors.bottomTabBarColor,
                backgroundColor = MyApplicationTheme.colors.bottomTabBarColor,
            ) {
                TabNavigationItem(tab = YoutubeTab)
            }
        }
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    val title = tab.options.title

    BottomNavigationItem(
        modifier = Modifier.background(MyApplicationTheme.colors.bottomTabBarColor),
        alwaysShowLabel = true,
        label = {
            Text(
                modifier = Modifier.padding(bottom = 4.sdp),
                text = title,
                style = MediaFont.lexendDeca(
                    size = if (isDesktop()) FontType.ExtraSmall else FontType.Small,
                    type = MediaFont.LexendDeca.Regular
                ),
            )
        },
        selected = tabNavigator.current.key == tab.key,
        onClick = { tabNavigator.current = tab },
        icon = {
            tab.options.icon?.let {
                Icon(
                    painter = it,
                    contentDescription = tab.options.title,
                    modifier = Modifier
                        .padding(top = 10.sdp, bottom = 5.sdp)
                        .size(if (isDesktop()) 14.sdp else 20.sdp)
                )
            }
        },
        selectedContentColor = Color.White,
        unselectedContentColor = MyApplicationTheme.colors.secondaryText
    )
}