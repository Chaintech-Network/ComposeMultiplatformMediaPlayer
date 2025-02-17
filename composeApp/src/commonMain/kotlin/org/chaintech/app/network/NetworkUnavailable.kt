package org.chaintech.app.network

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.chaintech.app.font.FontType
import org.chaintech.app.font.MediaFont
import org.chaintech.app.utility.getSafeAreaSize

@Composable
fun InternetOffline(connected: Boolean) {
    var lastConnectedState by remember { mutableStateOf(false) }

    LaunchedEffect(connected) {
        if (connected) lastConnectedState = true
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = getSafeAreaSize().top.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(if(connected || lastConnectedState) Color.Green else Color.Red)
                .padding(4.sdp)
                .wrapContentHeight(),
            contentAlignment = Alignment.Center
        ) {
            AnimatedContent(
                targetState = (connected || lastConnectedState),
                transitionSpec = {
                    fadeIn(animationSpec = tween(300)) togetherWith fadeOut(animationSpec = tween(300))
                }
            ) { isConnected ->
                val displayText = if (connected || lastConnectedState) "Connected" else "No Internet Connection"
                Text(
                    text = displayText,
                    color = Color.White,
                    style = MediaFont.lexendDeca(
                        size = FontType.Heading,
                        type = MediaFont.LexendDeca.Medium
                    ),
                    fontSize = 10.ssp,
                )
            }
        }
    }
}