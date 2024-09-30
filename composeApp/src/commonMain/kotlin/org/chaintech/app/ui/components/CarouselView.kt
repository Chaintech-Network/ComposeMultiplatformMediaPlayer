package org.chaintech.app.ui.components

import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import kotlinx.coroutines.delay
import network.chaintech.sdpcomposemultiplatform.sdp

const val CAROUSEL_AUTO_SCROLL_TIMER: Long = 3000L
const val ANIM_TIME_LONG: Int = 800

@Composable
fun TopBannerCarousel(
    pageCount: Int,
    autoScrollEnable: Boolean = true,
    autoScrollDuration: Long = CAROUSEL_AUTO_SCROLL_TIMER,
    content: @Composable ColumnScope.(index: Int) -> Unit,
) {
    val pagerState = rememberPagerState(pageCount = { pageCount })
    val isDragged by pagerState.interactionSource.collectIsDraggedAsState()

    // Handle auto-scrolling if enabled and not currently dragged
    if (autoScrollEnable && !isDragged) {
        AutoScrollEffect(pagerState, pageCount, autoScrollDuration)
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 12.sdp),
            pageSpacing = 7.sdp,
        ) { page ->
            content(page)
        }
    }
}

@Composable
private fun AutoScrollEffect(
    pagerState: PagerState,
    pageCount: Int,
    autoScrollDuration: Long
) {
    var currentPage by remember { mutableStateOf(0) }

    LaunchedEffect(currentPage) {
        if (pageCount > 0) {
            while (true) {
                delay(autoScrollDuration)
                val nextPage = (currentPage + 1) % pageCount
                pagerState.animateScrollToPage(
                    page = nextPage,
                    animationSpec = tween(durationMillis = ANIM_TIME_LONG)
                )
                currentPage = nextPage
            }
        }
    }
}