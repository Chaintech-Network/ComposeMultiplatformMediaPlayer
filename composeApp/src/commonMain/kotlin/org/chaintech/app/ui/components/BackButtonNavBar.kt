package org.chaintech.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import org.chaintech.app.utility.FromLocalDrawable
import network.chaintech.sdpcomposemultiplatform.sdp
import reelsdemo.composeapp.generated.resources.Res
import reelsdemo.composeapp.generated.resources.ic_back_button

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
        verticalArrangement = Arrangement.Top
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
                    .padding(horizontal = 16.sdp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier
                    .padding(top = 8.sdp)
                    .size(30.sdp)
                    .background(Color.Black.copy(alpha = 0.3f), shape = CircleShape)
                ) {
                    FromLocalDrawable(
                        painterResource = Res.drawable.ic_back_button,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(all = 5.sdp)
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