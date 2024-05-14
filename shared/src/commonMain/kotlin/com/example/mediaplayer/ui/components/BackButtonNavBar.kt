package com.example.mediaplayer.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import com.example.mediaplayer.utility.FromLocalDrawable
import mediaplayer.shared.generated.resources.Res
import mediaplayer.shared.generated.resources.ic_back_button
import network.chaintech.sdpcomposemultiplatform.sdp
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun BackButtonNavBar(
    modifier: Modifier = Modifier,
    onBackButtonClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 0.sdp,
                spotColor = Color.Transparent
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Transparent),
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.sdp, vertical = 15.sdp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(13.sdp)
                ) {

                    Box(modifier = Modifier.padding(top = 2.sdp)) {
                        FromLocalDrawable(
                            painterResource = Res.drawable.ic_back_button,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .height(12.sdp)
                                .pointerInput(Unit) {
                                    detectTapGestures { _ ->
                                        onBackButtonClick()
                                    }
                                }
                        )
                    }
                }
            }
        }
    }
}