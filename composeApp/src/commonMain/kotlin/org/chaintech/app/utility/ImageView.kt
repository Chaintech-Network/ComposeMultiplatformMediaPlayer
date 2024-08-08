package org.chaintech.app.utility

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import com.seiko.imageloader.model.ImageRequest
import com.seiko.imageloader.rememberImageAction
import com.seiko.imageloader.rememberImageActionPainter
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun FromLocalDrawable(
    painterResource: DrawableResource,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    colorFilter: ColorFilter? = null,
    onClick: (() -> Unit?)? = null
) {
    Image(
        painter = painterResource(painterResource),
        contentDescription = painterResource.toString(),
        contentScale = contentScale,
        colorFilter = colorFilter,
        modifier = modifier.then(
            if (onClick != null) {
                Modifier.clickable {
                    onClick()
                }
            } else {
                Modifier
            }
        )
    )
}
@Composable
fun FromRemote(
    painterResource: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.FillWidth,
) {
    Image(
        data = painterResource,
        modifier = modifier,
        contentScale = contentScale
    )
}

@Composable
fun Image(
    modifier: Modifier,
    data: Any,
    contentScale: ContentScale = ContentScale.Crop,
) {
    Box(modifier, Alignment.Center) {
        val request = remember(data, 0, true) {
            ImageRequest {
                data(data)
//                addInterceptor(NullDataInterceptor)
                options {
                    playAnimate = true
                }
            }
        }
        val action by rememberImageAction(request)
        val painter = rememberImageActionPainter(action)
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = contentScale,
            modifier = Modifier.fillMaxSize(),
        )
    }
}

//object NullDataInterceptor : Interceptor {
//
//    override suspend fun intercept(chain: Interceptor.Chain): ImageResult {
//        val data = chain.request.data
//        if (data === NullRequestData || data is String && data.isEmpty()) {
//            return ImageResult.Painter(
//                painter = EmptyPainter,
//            )
//        }
//        return chain.proceed(chain.request)
//    }
//
//    private object EmptyPainter : Painter() {
//        override val intrinsicSize: Size get() = Size.Unspecified
//        override fun DrawScope.onDraw() {}
//    }
//}