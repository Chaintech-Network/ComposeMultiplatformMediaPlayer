package chainteck.network.app.ui.screens.videoplayerview

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
import chaintech.videoplayer.model.PlayerConfig
import chaintech.videoplayer.ui.video.VideoPlayerView
import chainteck.network.app.font.FontType
import chainteck.network.app.font.MediaFont
import chainteck.network.app.model.MockData
import chainteck.network.app.model.VideoModel
import chainteck.network.app.navigation.LocalNavigation
import chainteck.network.app.theme.MyApplicationTheme
import chainteck.network.app.ui.components.AddBanner
import chainteck.network.app.ui.components.BackButtonNavBar
import chainteck.network.app.utility.FromLocalDrawable
import chainteck.network.app.utility.FromRemote
import chainteck.network.app.utility.getSafeAreaSize
import mediaplayer.composeapp.generated.resources.Res
import mediaplayer.composeapp.generated.resources.icn_add
import mediaplayer.composeapp.generated.resources.icn_download
import mediaplayer.composeapp.generated.resources.icn_share
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.jetbrains.compose.resources.DrawableResource

class VideoPlayerView(private val currentVideo: VideoModel) : Screen {
    @Composable
    override fun Content() {
        VideoPlayerContentView(currentVideo)
    }
}

@Composable
private fun VideoPlayerContentView(currentVideo: VideoModel) {
    val navigator = LocalNavigation.current
    var video by remember { mutableStateOf(currentVideo) }

    Column(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = MyApplicationTheme.colors.gradientPrimary,
                )
            )
            .fillMaxSize()
            .padding(top = getSafeAreaSize().top.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Box(
            modifier = Modifier,
             contentAlignment = Alignment.TopStart
        ){
            VideoPlayerView(
                modifier = Modifier.fillMaxWidth()
                    .height(224.sdp),
                url = video.sources,
                playerConfig = PlayerConfig(
                    seekBarActiveTrackColor = Color.Red,
                    seekBarInactiveTrackColor = Color.White,
                    seekBarBottomPadding = 8.sdp,
                    pauseResumeIconSize = 30.sdp,
                    controlHideIntervalSeconds = 5,
                    topControlSize = 20.sdp,
                    durationTextStyle = MediaFont.lexendDeca(
                        size = FontType.Regular,
                        type = MediaFont.LexendDeca.Medium
                    ),
                    fastForwardBackwardIconSize = 28.sdp,
                    controlTopPadding = 10.sdp
                )
            )

            BackButtonNavBar {
                navigator.back()
            }
        }

        Spacer(modifier = Modifier.height(4.sdp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(horizontal = 8.sdp)
        ) {
            item (span = {
                GridItemSpan(2)
            })
                {
                videoDetails(video)
            }

            items(MockData().getFilteredData(video)) {
                Column(
                    modifier = Modifier.padding(4.sdp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.sdp)
                            .clip(RoundedCornerShape(8.sdp))
                            .background(MyApplicationTheme.colors.border)
                            .border(
                                width = 1.sdp,
                                color = MyApplicationTheme.colors.border,
                                shape =  RoundedCornerShape(8.sdp)
                            )
                            .pointerInput(Unit) {
                                detectTapGestures { _ ->
                                    video = it
                                }
                            }

                    ){
                        FromRemote(
                            painterResource = it.thumb,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                }
            }

            item (span = {
                GridItemSpan(2)
            })
            {
                Spacer(modifier = Modifier.height(16.sdp))
            }
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
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = video.title,
                style = MediaFont.lexendDeca(
                    size = FontType.SubHeading,
                    type = MediaFont.LexendDeca.Medium
                ),
                color = MyApplicationTheme.colors.white,
                modifier = Modifier.padding(horizontal = 4.sdp)
            )

            Spacer(modifier = Modifier.height(4.sdp))

            Text(
                text = video.subtitle,
                style = MediaFont.lexendDeca(
                    size = FontType.Small,
                    type = MediaFont.LexendDeca.Regular
                ),
                color = MyApplicationTheme.colors.secondaryText,
                modifier = Modifier.padding(horizontal = 4.sdp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            downLoadView()

            Spacer(modifier = Modifier.height(8.sdp))
            AddBanner(
                title = "Anokhi Kahani Atoot Bandhan ki",
                image = MockData().detailBanner,
                padding = 5.sdp
            )

            Spacer(modifier = Modifier.height(20.sdp))

            Text(
                text = "More Like This",
                style = MediaFont.lexendDeca(
                    size = FontType.SubHeading,
                    type = MediaFont.LexendDeca.Medium
                ),
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
private fun downLoadView() {
    Row(
        modifier = Modifier.padding(vertical =  12.sdp, horizontal = 4.sdp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(20.sdp)
    ) {

        downloadItem(Res.drawable.icn_add, "Watchlist")

        downloadItem(Res.drawable.icn_share, "Share", size = 16.sdp)

        downloadItem(Res.drawable.icn_download, "Download")

    }
}

@Composable
private fun downloadItem(
    image: DrawableResource,
    title: String,
    size: Dp = 19.sdp) {
    Column(
        modifier = Modifier. height(32.sdp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FromLocalDrawable(
            painterResource = image,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(size)
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = title,
            style = MediaFont.lexendDeca(
                size = FontType.Small,
                type = MediaFont.LexendDeca.Regular
            ),
            color = MyApplicationTheme.colors.white,
            modifier = Modifier,
            maxLines = 1
        )
    }
}
