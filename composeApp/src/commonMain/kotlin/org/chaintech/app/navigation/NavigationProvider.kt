package org.chaintech.app.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import org.chaintech.app.model.VideoModel
import kotlinx.coroutines.flow.MutableStateFlow

class NavigationProvider : Navigation {

    private val navigatorStack = MutableStateFlow<Navigator?>(null)
    private val screenContainer = MutableStateFlow<ScreenContainer?>(null)

    @Composable
    fun initialize() {
        navigatorStack.value = LocalNavigator.current
        screenContainer.value = LocalScreenContainer.current
    }

    override fun back(): Boolean {
        return tryAction { it.pop() }
    }

    override fun backToRoot(): Boolean {
        return tryAction { nav ->
//            nav.popUntil { it.key }
            nav.popUntilRoot()
        }
    }
    override fun goToVideoPlayerScreen(currentVideo: VideoModel, videoList: List<VideoModel>): Boolean {
        return tryAction { nav ->
            screenContainer.value?.goToVideoPlayerScreen(currentVideo, videoList)?.let {
                nav.push(it)
            }
        }
    }

    private fun tryAction(action: (Navigator) -> Unit): Boolean {
        return try {
            navigatorStack.value?.let(action)
            true
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            false
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}