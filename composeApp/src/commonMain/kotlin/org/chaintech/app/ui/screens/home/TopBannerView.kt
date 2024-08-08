package org.chaintech.app.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import org.chaintech.app.model.MockData
import org.chaintech.app.model.VideoModel
import org.chaintech.app.navigation.LocalNavigation
import org.chaintech.app.theme.MyApplicationTheme
import org.chaintech.app.ui.components.TopBannerCarousel
import org.chaintech.app.utility.FromRemote
import network.chaintech.sdpcomposemultiplatform.sdp

@Composable
fun TopView() {
    val navigator = LocalNavigation.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 11.sdp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        val videoList = MockData().topBannerData()

        TopBannerCarousel(pageCount = videoList.size, content = { index ->
            val item = videoList[index]
            TopMovieBannerCarouselView(item, onClickEvent = {
                navigator.goToVideoPlayerScreen(item)
            })
        })
    }
}

@Composable
private fun TopMovieBannerCarouselView(item: VideoModel, onClickEvent: () -> Unit) {
    val roundedCornerShape = RoundedCornerShape(7.sdp)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(360.sdp)
            .background(
                color = Color.Transparent,
                shape = roundedCornerShape
            )
            .border(
                width = 1.sdp,
                color = MyApplicationTheme.colors.border,
                shape = roundedCornerShape
            )
            .clip(RoundedCornerShape(14.sdp))
            .pointerInput(Unit) {
                detectTapGestures { _ ->
                    onClickEvent()
                }
            }
    ) {
        FromRemote(
            painterResource = item.thumb,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent, shape = roundedCornerShape)
                .clip(roundedCornerShape)
        )
    }
}