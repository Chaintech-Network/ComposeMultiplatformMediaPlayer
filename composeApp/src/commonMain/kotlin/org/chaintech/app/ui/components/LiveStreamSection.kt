package org.chaintech.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.chaintech.app.font.FontType
import org.chaintech.app.font.MediaFont
import org.chaintech.app.model.MockData
import org.chaintech.app.navigation.LocalNavigation
import org.chaintech.app.theme.MyApplicationTheme
import org.chaintech.app.utility.FromRemote

@Composable
fun LiveStreamSection(
    title: String,
    width: Dp = 80.sdp,
    height: Dp = 80.sdp
) {
    val navigator = LocalNavigation.current
    val dataStore= MockData().liveStreamData

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.sdp),
        verticalArrangement = Arrangement.spacedBy(16.sdp),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = title,
            style = MediaFont.lexendDeca(
                size = FontType.Heading,
                type = MediaFont.LexendDeca.Medium
            ),
            fontSize = 16.ssp,
            fontWeight = FontWeight.Bold,
            color = MyApplicationTheme.colors.white,
            modifier = Modifier,
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(10.sdp),
        ) {
            itemsIndexed(dataStore) { _, item ->
                Card(shape = RoundedCornerShape(7.sdp)) {
                    FromRemote(
                        painterResource = item.thumb,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(width)
                            .height(height)
                            .background(MyApplicationTheme.colors.border)
                            .pointerInput(Unit) {
                                detectTapGestures { _ ->
                                    navigator.goToVideoPlayerScreen(item, dataStore)
                                }
                            }
                    )
                }
            }
        }
    }
}