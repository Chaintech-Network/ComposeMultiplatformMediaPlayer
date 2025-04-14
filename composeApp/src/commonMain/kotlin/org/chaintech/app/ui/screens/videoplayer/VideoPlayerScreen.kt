package org.chaintech.app.ui.screens.videoplayer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import chaintech.videoplayer.host.MediaPlayerError
import chaintech.videoplayer.host.MediaPlayerEvent
import chaintech.videoplayer.host.MediaPlayerHost
import chaintech.videoplayer.model.VideoPlayerConfig
import chaintech.videoplayer.model.WatermarkConfig
import chaintech.videoplayer.ui.video.VideoPlayerComposable
import chaintech.videoplayer.util.isDesktop
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.chaintech.app.font.FontType
import org.chaintech.app.font.MediaFont
import org.chaintech.app.model.MockData
import org.chaintech.app.model.VideoModel
import org.chaintech.app.navigation.LocalNavigation
import org.chaintech.app.theme.MyApplicationTheme
import org.chaintech.app.ui.components.AddBanner
import org.chaintech.app.ui.components.BackButtonNavBar
import org.chaintech.app.utility.FromLocalDrawable
import org.chaintech.app.utility.FromRemote
import org.chaintech.app.utility.getSafeAreaSize
import org.chaintech.app.utility.showSeperateBackButton
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import reelsdemo.composeapp.generated.resources.Res
import reelsdemo.composeapp.generated.resources.icn_add
import reelsdemo.composeapp.generated.resources.icn_download
import reelsdemo.composeapp.generated.resources.icn_share
import reelsdemo.composeapp.generated.resources.watermark

class VideoPlayerScreen(private val currentVideo: VideoModel, private val videoList: List<VideoModel>) : Screen {
    @Composable
    override fun Content() {
        VideoPlayerContent(currentVideo, videoList)
    }
}

@Composable
private fun VideoPlayerContent(currentVideo: VideoModel, videoList: List<VideoModel>) {
    val navigator = LocalNavigation.current
    var video by remember { mutableStateOf(currentVideo) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors = MyApplicationTheme.colors.gradientPrimary))
            .padding(top = getSafeAreaSize().top.dp),
        horizontalAlignment = Alignment.Start
    ) {
        if (showSeperateBackButton(video.sources)) {
            BackButtonNavBar { navigator.back() }
        }

        VideoPlayerBox(video)

        if (!isDesktop()) {
            Spacer(modifier = Modifier.height(4.sdp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(horizontal = 8.sdp)
            ) {
                item(span = { GridItemSpan(2) }) {
                    videoDetails(video)
                }
                items(MockData().getFilteredData(videoList, video)) { item ->
                    VideoThumbnail(item) { video = item }
                }
                item(span = { GridItemSpan(2) }) {
                    Spacer(modifier = Modifier.height(16.sdp))
                }
            }
        }
    }
}

@Composable
private fun VideoPlayerBox(video: VideoModel) {
    val navigator = LocalNavigation.current
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopStart
    ) {
        val playerHost = remember { MediaPlayerHost(mediaUrl = video.sources) }
        playerHost.loadUrl(video.sources)

        playerHost.onError = { error ->
            when(error) {
                is MediaPlayerError.VlcNotFound -> {
//                    println("Error: ${error.message}")
                }
                is MediaPlayerError.InitializationError -> {
//                    println("Error: ${error.message}")
                }
                is MediaPlayerError.PlaybackError -> {
//                    println("Error: ${error.message}")
                }
                is MediaPlayerError.ResourceError -> {
//                    println("Error: ${error.message}")
                }
            }
        }
        playerHost.onEvent = { event ->
            when (event) {
                is MediaPlayerEvent.MuteChange -> {
//                    println("Mute status changed: ${event.isMuted}")
                }
                is MediaPlayerEvent.PauseChange -> {
//                    println("Pause status changed: ${event.isPaused}")
                }
                is MediaPlayerEvent.BufferChange -> {
//                    println("Buffering status: ${event.isBuffering}")
                }
                is MediaPlayerEvent.CurrentTimeChange -> {
//                    println("Current playback time: ${event.currentTime}s")
                }
                is MediaPlayerEvent.TotalTimeChange -> {
//                    println("Video duration updated: ${event.totalTime}s")
                }
                is MediaPlayerEvent.FullScreenChange -> {
//                    println("FullScreen status changed: ${event.isFullScreen}")
                }
                MediaPlayerEvent.MediaEnd -> {
//                    println("Video playback ended")
                }
            }
        }

        VideoPlayerComposable(
            modifier = Modifier.then(
                if (isDesktop()) Modifier.fillMaxSize() else Modifier.height(224.sdp).fillMaxWidth()
            ),
            playerHost = playerHost,
            playerConfig = VideoPlayerConfig(
                seekBarActiveTrackColor = Color.Red,
                seekBarInactiveTrackColor = Color.White,
                seekBarBottomPadding = 8.sdp,
                pauseResumeIconSize = if (isDesktop()) 18.sdp else 30.sdp,
                controlHideIntervalSeconds = 5,
                topControlSize = if (isDesktop()) 16.sdp else 20.sdp,
                durationTextStyle = MediaFont.lexendDeca(
                    size = if (isDesktop()) FontType.ExtraSmall else FontType.Regular,
                    type = MediaFont.LexendDeca.Medium
                ),
                fastForwardBackwardIconSize = if (isDesktop()) 16.sdp else 28.sdp,
                controlTopPadding = 10.sdp,
//                isLiveStream = isLiveStream(video.sources)
                watermarkConfig = WatermarkConfig(
                    content = {
                        Image(
                            painter = painterResource(Res.drawable.watermark) ,
                            contentDescription = "Watermark",
                            modifier = Modifier
                                .size(80.sdp)
                        )
                    },
                    stayDelay = 4000L,
                    hideDelay = 4000L
                )
            )
        )

        if (!showSeperateBackButton(video.sources)) {
            BackButtonNavBar { navigator.back() }
        }
    }
}

@Composable
private fun videoDetails(video: VideoModel) {
    Row(
        modifier = Modifier.padding(vertical = 13.sdp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(7.sdp)
    ) {
        Column(horizontalAlignment = Alignment.Start) {
            Text(
                text = video.title,
                style = MediaFont.lexendDeca(size = FontType.SubHeading, type = MediaFont.LexendDeca.Medium),
                color = MyApplicationTheme.colors.white,
                modifier = Modifier.padding(horizontal = 4.sdp)
            )

            Spacer(modifier = Modifier.height(4.sdp))

            Text(
                text = video.subtitle,
                style = MediaFont.lexendDeca(size = FontType.Small, type = MediaFont.LexendDeca.Regular),
                color = MyApplicationTheme.colors.secondaryText,
                modifier = Modifier.padding(horizontal = 4.sdp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            downLoadComponent()

            Spacer(modifier = Modifier.height(8.sdp))

            AddBanner(title = "Demon Slayer Season 1 &2", image = MockData().detailBanner, padding = 5.sdp)

            Spacer(modifier = Modifier.height(20.sdp))

            Text(
                text = "More Like This",
                style = MediaFont.lexendDeca(size = FontType.SubHeading, type = MediaFont.LexendDeca.Medium),
                fontSize = 14.ssp,
                fontWeight = FontWeight.Bold,
                color = MyApplicationTheme.colors.white,
                modifier = Modifier.padding(horizontal = 4.sdp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun downLoadComponent() {
    Row(
        modifier = Modifier.padding(vertical = 12.sdp, horizontal = 4.sdp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(20.sdp)
    ) {
        downloadItem(Res.drawable.icn_add, "Watchlist")
        downloadItem(Res.drawable.icn_share, "Share", size=14.sdp, modifier = Modifier.padding(top = 4.sdp))
        downloadItem(Res.drawable.icn_download, "Download")
    }
}

@Composable
private fun downloadItem(image: DrawableResource, title: String, size: Dp=19.sdp, modifier: Modifier = Modifier) {
    Column(horizontalAlignment=Alignment.CenterHorizontally, modifier = modifier) {
        FromLocalDrawable(painterResource=image, contentScale=ContentScale.Fit, modifier=Modifier.size(size))

        Spacer(modifier=Modifier.weight(1f))

        Text(
            text=title,
            style=MediaFont.lexendDeca(size=FontType.Small, type=MediaFont.LexendDeca.Regular),
            color=MyApplicationTheme.colors.white,
            maxLines=1
        )
    }
}

@Composable
private fun VideoThumbnail(video: VideoModel, onClick: () -> Unit) {
    Column(modifier=Modifier.padding(4.sdp)) {
        Box(
            modifier=Modifier
                .fillMaxWidth()
                .height(200.sdp)
                .clip(RoundedCornerShape(8.sdp))
                .background(MyApplicationTheme.colors.border)
                .border(width=1.sdp, color=MyApplicationTheme.colors.border, shape=RoundedCornerShape(8.sdp))
                .pointerInput(Unit) { detectTapGestures { onClick() } }
        ) {
            FromRemote(painterResource = video.thumb, contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize())
        }
    }
}
