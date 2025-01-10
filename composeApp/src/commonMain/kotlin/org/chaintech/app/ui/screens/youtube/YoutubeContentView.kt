package org.chaintech.app.ui.screens.youtube

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import chaintech.videoplayer.ui.preview.VideoPreviewComposable
import network.chaintech.sdpcomposemultiplatform.sdp
import org.chaintech.app.font.FontType
import org.chaintech.app.font.MediaFont
import org.chaintech.app.model.MockData
import org.chaintech.app.model.VideoModel
import org.chaintech.app.navigation.LocalNavigation
import org.chaintech.app.theme.MyApplicationTheme
import org.chaintech.app.utility.FromRemote
import org.jetbrains.compose.resources.painterResource
import reelsdemo.composeapp.generated.resources.Res
import reelsdemo.composeapp.generated.resources.youtubeLogo

@Composable
fun YoutubeContentScreen() {
    val videoList = MockData().youtbeMockData.shuffled()
    val navigator = LocalNavigation.current

    // State to track the scroll position
    val listState = rememberLazyListState()

    Scaffold(
        topBar = { TopBarYouTube() }
    ) {
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(colors = MyApplicationTheme.colors.gradientPrimary)
                )
        ) {
            itemsIndexed(videoList) { index, video ->
                val isFocused = isItemFocused(listState, index) // Check if this item is focused
                VideoItem(video, isFocused) {
                    navigator.goToVideoPlayerScreen(video, videoList)
                }
            }
        }
    }
}

// Function to check if an item is the most focused one
@Composable
fun isItemFocused(listState: LazyListState, index: Int): Boolean {
    val visibleItems = listState.layoutInfo.visibleItemsInfo
    if (visibleItems.isEmpty()) return false

    // Calculate the middle position of the viewport
    val viewportCenter = listState.layoutInfo.viewportStartOffset +
            (listState.layoutInfo.viewportEndOffset - listState.layoutInfo.viewportStartOffset) / 2

    // Find the item closest to the center
    val centeredItem = visibleItems.minByOrNull { item ->
        val itemCenter = (item.offset + item.size / 2)
        kotlin.math.abs(itemCenter - viewportCenter)
    }

    // Return true if the current index matches the centered item's index
    return centeredItem?.index == index
}


@Composable
private fun VideoItem(video: VideoModel, isFocused: Boolean, onClick: () -> Unit) {
    val mockData = MockData().previewUrls()

    Column(
        modifier = Modifier.padding(vertical = 5.sdp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.sdp)
                .background(MyApplicationTheme.colors.border)
                .pointerInput(Unit) {
                    detectTapGestures { onClick() }
                }
        ) {
            if (isFocused) {
                VideoPreviewComposable(
                    url = mockData.random(),
                    frameCount = 7
                )
            } else {
                FromRemote(
                    painterResource = video.thumbL,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        VideoDetails(video)
    }
}

@Composable
private fun VideoDetails(video: VideoModel) {
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 12.dp)
    ) {
        Column {
            Text(
                text = video.title,
                style = MediaFont.lexendDeca(size = FontType.Regular, type = MediaFont.LexendDeca.Medium),
                color = MyApplicationTheme.colors.white,
                modifier = Modifier.padding(horizontal = 4.sdp)
            )

            Spacer(modifier = Modifier.height(2.sdp))

            Text(
                text = "${video.subtitle} - ${video.rating} views - ${video.date}",
                style = MediaFont.lexendDeca(size = FontType.Small, type = MediaFont.LexendDeca.Regular),
                color = MyApplicationTheme.colors.secondaryText,
                modifier = Modifier.padding(horizontal = 4.sdp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        Icon(
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = null,
            tint = Color.White
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBarYouTube() {
    TopAppBar(
        title = {
            Image(
                painter = painterResource(Res.drawable.youtubeLogo),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(0.4f)
            )
        },
        actions = {
            IconButton(onClick = { /* TODO: Handle notifications */ }) {
                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(20.sdp)
                )
            }
            IconButton(onClick = { /* TODO: Handle search */ }) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(20.sdp)
                )
            }
        },
        modifier = Modifier.background(Color.Black)
    )
}