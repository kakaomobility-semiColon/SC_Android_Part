package com.main.sc_android_part.view.map

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.kakao.vectormap.KakaoMap
import com.kakao.vectormap.KakaoMapReadyCallback
import com.kakao.vectormap.MapLifeCycleCallback
import com.kakao.vectormap.MapView


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen() {
    val context = LocalContext.current
    val mapView = rememberMapView(context = context)

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
    ) { paddingValue ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValue)
        ) {
            AndroidView(
                factory = {
                    mapView
                },
            )
        }
    }
}

@Composable
fun rememberMapView(
    context: Context,
): MapView {
    val mapView = remember {
        MapView(context).also { mapView ->
            mapView.start(
                object : MapLifeCycleCallback() {
                    override fun onMapDestroy() = Unit
                    override fun onMapError(e: Exception?) = Unit
                    override fun onMapResumed() = Unit
                },

                object : KakaoMapReadyCallback() {
                    override fun onMapReady(map: KakaoMap) = Unit
                }
            )
        }
    }

    return mapView
}
