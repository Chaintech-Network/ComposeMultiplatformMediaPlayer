package org.chaintech.app.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import chaintech.videoplayer.util.isDesktop
import org.chaintech.app.model.MockData
import org.chaintech.app.theme.MyApplicationTheme
import org.chaintech.app.ui.components.AddBanner
import org.chaintech.app.ui.components.HomeVideoSection
import org.chaintech.app.utility.getSafeAreaSize
import network.chaintech.sdpcomposemultiplatform.sdp
import org.chaintech.app.ui.components.LiveStreamSection
import org.chaintech.app.ui.components.LocalVideoSection

@Composable
fun HomeScreen() {
    val dataStore = MockData()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(colors = MyApplicationTheme.colors.gradientPrimary)
            )
    ) {
        item {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.sdp)
            ) {
                TopSection()

                LiveStreamSection(title = "Live Stream \uD83D\uDD34")

                AddBanner(
                    title = "Subscribe Now",
                    image = dataStore.topAddBanner
                )

                LocalVideoSection(title = "Local Videos \uD83D\uDD25")

                HomeVideoSection(data = dataStore.hotRightNow(), title = "Hot Right Now")
                HomeVideoSection(data = dataStore.machoMix(), title = "Macho Mix: Must Watch Movies")
                HomeVideoSection(data = dataStore.popularInKids(), title = "Popular In Kids & Family")
                HomeVideoSection(data = dataStore.actionAdventure(), title = "Action & Adventure")

                AddBanner(
                    title = "Motu Patlu: Streaming Now",
                    image = dataStore.bottomAddBanner
                )

                HomeVideoSection(data = dataStore.hollywoodFinest(), title = "Hollywood's Finest")
                HomeVideoSection(data = dataStore.southDubbed(), title = "South Dubbed Hits")
                HomeVideoSection(data = dataStore.globalHits(), title = "Global Hits In Hindi")

                Spacer(modifier = Modifier.height(if (isDesktop()) { 10.sdp } else { 56.sdp }))
            }
        }
    }
}

@Composable
private fun TopSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.linearGradient(colors = MyApplicationTheme.colors.homeTopGradient)
            )
    ) {
        Column(
            modifier = Modifier
                .padding(top = getSafeAreaSize().top.dp)
                .fillMaxSize()
        ) {
            TopComponent()
        }
    }
}